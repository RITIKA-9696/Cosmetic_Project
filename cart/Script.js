document.addEventListener('DOMContentLoaded', () => {
  const cartIcon = document.querySelector('.cart-icon');
  const cartModal = document.querySelector('.cart-modal');
  const closeBtn = document.querySelector('.close-btn');
  const cartBtns = document.querySelectorAll('.cart-btn');
  const cartCount = document.querySelector('.cart-count');
  const cartItemsList = document.querySelector('.cart-items');

  let cartItems = [];
  let itemCount = 0;

  cartIcon.addEventListener('click', () => {
      cartModal.style.display = 'flex';
      updateCart();
  });

  closeBtn.addEventListener('click', () => {
      cartModal.style.display = 'none';
  });

  cartBtns.forEach((btn, index) => {
      btn.addEventListener('click', () => {
          const productItem = btn.closest('.product-item');
          const productName = productItem.querySelector('h2').textContent;
          const productDesc = productItem.querySelector('p').textContent;
          
          const product = {
              name: productName,
              description: productDesc,
              quantity: 1
          };

          addToCart(product);
      });
  });

  function addToCart(product) {
      const existingItemIndex = cartItems.findIndex(item => item.name === product.name);
      
      if (existingItemIndex > -1) {
          cartItems[existingItemIndex].quantity += 1;
      } else {
          cartItems.push(product);
      }

      itemCount += 1;
      cartCount.textContent = itemCount;
  }

  function updateCart() {
      cartItemsList.innerHTML = '';
      cartItems.forEach(item => {
          const li = document.createElement('li');
          li.textContent = `${item.name} (x${item.quantity}) - ${item.description}`;
          cartItemsList.appendChild(li);
      });
  }
});

// // Function to add items to the cart
// function addItem(name, price) {
//     var cart = document.getElementById("cart");
//     var item = document.createElement("li");
//     item.textContent = name + " - $" + price;
//     cart.appendChild(item);
// }

// // Event listener for Add to Cart buttons
// document.querySelectorAll('.add-to-cart').forEach(button => {
//     button.addEventListener('click', function() {
//         var name = this.getAttribute('data-name');
//         var price = parseFloat(this.getAttribute('data-price'));
//         addItem(name, price);
//     });
// });

