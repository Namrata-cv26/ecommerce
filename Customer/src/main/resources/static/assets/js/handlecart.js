function handleCartAction(event) {
    // Recompute the total price using your logic
    var totalPrice = computeTotalPrice(); // Implement computeTotalPrice function

    // Update the visibility of the "Proceed to Checkout" button based on the recalculated totalPrice
    var checkoutButton = document.getElementById('checkoutButton');
    if (totalPrice > 0) {
        checkoutButton.style.display = 'block';
    } else {
        checkoutButton.style.display = 'none';
    }
}

function computeTotalPrice() {

}
