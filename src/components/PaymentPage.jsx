import { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import './PaymentPage.css';
const PaymentPage = () => {
  const { audioId } = useParams(); // To get the audioId from URL params (passed from the "Buy" button)
  const [audio, setAudio] = useState(null);
  const [paymentMethod, setPaymentMethod] = useState('');
  const [paymentStatus, setPaymentStatus] = useState('Pending'); // Initial payment status
  const [amountPaid, setAmountPaid] = useState(0);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  // Fetch the audio details by audioId
  useEffect(() => {
    fetch(`http://localhost:8080/api/audio/${audioId}`)
      .then((response) => response.json())
      .then((data) => {
        setAudio(data);
        setAmountPaid(data.price); // Assuming 'price' is part of the audio data
        setLoading(false);
      })
        .catch((error) => {
            console.error('Error fetching audio:', error);
            setError('Error fetching audio');
            setLoading(false);
        });
      
  }, [audioId]);

  // Handle payment submission
  const handlePaymentSubmit = () => {
    setPaymentStatus('Processing'); // Set status before making the request

    const paymentDetails = {
      amountPaid,
      paymentMethod,
      paymentStatus: 'Pending', // Status sent to the server
      paymentDate: new Date().toISOString(),
      order: {
        orderId: audioId, // Assuming you have an order ID for the specific purchase
      },
    };

    fetch('http://localhost:8080/api/payment/addPaymentDetails', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(paymentDetails),
    })
      .then((response) => response.json())
      .then((data) => {
        setPaymentStatus('Success'); // Update status on success
        alert('Payment successful!');
        navigate(`/confirmation/${data.paymentid}`); // Navigate to a confirmation page
      })
        .catch((error) => {
            console.error('Error processing payment:', error);
            setPaymentStatus('Failed'); // Update status on failure
        });
  };

  return (
    <div className="payment-page container mx-auto p-4">
      {loading && <p>Loading payment details...</p>}
      {error && <p style={{ color: 'red' }}>{error}</p>}

      {audio && (
        <div className="payment-details">
          <h2>Payment for {audio.title}</h2>
          <div>
            <img
              src={
                audio.imageUrl
                  ? `http://localhost:8080/assets/images/${audio.imageUrl}`
                  : '/default-image.jpg'
              }
              
              alt={audio.title}
              className="w-full h-48 object-cover rounded-md mb-4"
            />
            <p>
              <strong>Price:</strong> ${audio.price}
            </p>

            {/* Payment Method */}
            <div>
              <label htmlFor="payment-method" className="block">
                Select Payment Method
              </label>
              <select
                id="payment-method"
                value={paymentMethod}
                onChange={(e) => setPaymentMethod(e.target.value)}
                className="border p-2 mt-2 rounded-md"
              >
                <option value="">Select Method</option>
                <option value="Credit Card">Credit Card</option>
                <option value="PayPal">PayPal</option>
                <option value="Bank Transfer">Bank Transfer</option>
              </select>
            </div>

            {/* Payment Status */}
            <div className="mt-4">
              <p>
                <strong>Payment Status:</strong> {paymentStatus}
              </p>
            </div>

            <div className="mt-4">
              <button
                onClick={handlePaymentSubmit}
                className="bg-green-600 text-white p-2 rounded-md"
                disabled={paymentStatus === 'Processing'}
              >
                {paymentStatus === 'Processing' ? 'Processing...' : 'Confirm Payment'}
              </button>

            </div>
          </div>
        </div>
      )}
    </div>
    
    
  );
};

export default PaymentPage;
