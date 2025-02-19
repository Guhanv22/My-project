import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { Button, TextField, Typography, Box } from "@mui/material";
import "./ViewPage.css";

const ViewPage = () => {
  const { audioId } = useParams();
  const [audio, setAudio] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [reviewText, setReviewText] = useState("");
  const [reviews, setReviews] = useState([]);

  // API base URL - move this to an environment variable in production
  const API_BASE_URL = "http://localhost:8080";

  // Fetch audio details
  useEffect(() => {
    if (!audioId) {
      setError("Audio ID is missing or invalid.");
      setLoading(false);
      return;
    }

    const fetchAudio = async () => {
      try {
        const response = await fetch(`${API_BASE_URL}/api/audio/${audioId}`);

        if (response.status === 404) {
          throw new Error("Audio not found");
        }

        if (!response.ok) {
          throw new Error(`HTTP e
            rror! status: ${response.status}`);
        }

        const data = await response.json();
        setAudio(data);
      } catch (error) {
        console.error("Fetch error:", error);
        setError(error.message);
      } finally {
        setLoading(false);
      }
    };

    fetchAudio();
  }, [audioId]);

  // Fetch reviews
  useEffect(() => {
    if (audio?.audioId) {
      const fetchReviews = async () => {
        try {
          const token = localStorage.getItem("token"); // Get stored JWT token
          const response = await fetch(`${API_BASE_URL}/api/review/audiocast/${audio.audioId}`, {
            method: "GET",
            headers: {
              "Authorization": `Bearer ${token}`,  // Add token to request
              "Accept": "application/json",
              "Content-Type": "application/json"
            }
          });
      
          if (response.status === 401) {
            throw new Error("Unauthorized. Please log in again.");
          }
      
          if (response.status === 404) {
            console.warn("No reviews found for this audio.");
            setReviews([]); // Handle empty reviews gracefully
            return;
          }
      
          if (!response.ok) {
            throw new Error(`Failed to fetch reviews: ${response.status}`);
          }
      
          const data = await response.json();
          setReviews(data);
        } catch (error) {
          console.error("Error fetching reviews:", error);
        }
      };
      
      fetchReviews();
    }
  }, [audio]);

  // Handle review submission
  const handleReviewSubmit = async () => {
    if (!audio?.audioId || !reviewText.trim()) {
      return;
    }

    const review = {
      audiocastId: audio.audioId,
      commenttext: reviewText,
      reviewDate: new Date().toISOString(),
      rating: 5.0
    };

    try {
      const response = await fetch(`${API_BASE_URL}/api/review/addReviewDetails`, {
        method: "POST",
        headers: {
          "Accept": "application/json",
          "Content-Type": "application/json"
        },
        body: JSON.stringify(review)
      });

      if (!response.ok) {
        throw new Error("Failed to post review");
      }

      const data = await response.json();
      setReviews([...reviews, data]);
      setReviewText("");
    } catch (error) {
      console.error("Error posting review:", error);
    }
  };

  if (loading) return <Typography>Loading...</Typography>;
  if (error) return <Typography color="error">Error: {error}</Typography>;
  if (!audio) return <Typography>No audio found</Typography>;

  return (
    <div className="view-page">
      <Typography variant="h2">{audio.title}</Typography>

      {/* Audio Player */}
      <Box my={4}>
        <audio controls>
          <source src={`/assets/${audio.audioFile}`} type="audio/mp3" />
          Your browser does not support the audio element.
        </audio>
      </Box>

      <Typography variant="body1">{audio.description}</Typography>

      {/* Reviews Section */}
      <Box my={4}>
        <Typography variant="h4">Reviews</Typography>
        {reviews.length > 0 ? (
          <ul>
            {reviews.map((review) => (
              <li key={review.id}>
                <Typography variant="body1">{review.commenttext}</Typography>
                <Typography variant="caption">
                  {new Date(review.reviewDate).toDateString()}
                </Typography>
              </li>
            ))}
          </ul>
        ) : (
          <Typography variant="body2">No reviews yet.</Typography>
        )}
      </Box>

      {/* Review Submission */}
      <Box my={4}>
        <TextField
          fullWidth
          variant="outlined"
          label="Write a review"
          value={reviewText}
          onChange={(e) => setReviewText(e.target.value)}
        />
        <Button
          variant="contained"
          color="primary"
          onClick={handleReviewSubmit}
          disabled={!reviewText.trim()}
          sx={{ mt: 2 }}
        >
          Submit Review
        </Button>
      </Box>
    </div>
  );
};

export default ViewPage;