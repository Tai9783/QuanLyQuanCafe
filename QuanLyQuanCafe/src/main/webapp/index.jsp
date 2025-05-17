<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Coffee Shop</title>
 
</head>
  <style>
    * {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: sans-serif;
  margin: 0;
  padding: 0;
}


.logo {
  font-family: 'cursive';
  font-size: 24px;
  color: white;
  text-decoration: none; 
}


 header { 
    display: flex; 
    justify-content: space-between; 
    align-items: center; 
    background: #3c1f0d; 
    color: white; 
    padding: 16px 32px; 
  } 
   
  header .logo { 
    font-family: 'Brush Script MT', cursive; 
    font-size: 28.8px; 
  } 
   
  header nav a { 
    margin-left: 32px; 
    color: white; 
    text-decoration: none; 
    font-weight: bold; 
  } 


.hero {
  height: 600px;
  background-image: url('./images/anhcafeHome.png');
  background-size: cover;
  background-position: center;
  display: flex;
  align-items: center;
  justify-content: flex-start;
  padding:50px 20px;
  position: relative;
}

.hero::before {
  content: "";
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: rgba(0,0,0,0.5);
  z-index: 0;
}

.hero-text {
  color: white;
  z-index: 1;
  max-width: 500px;
}

.hero-text h1 {
  font-size: 48px;
  font-weight: bold;
  margin-bottom: 10px;
}

.hero-text p {
  font-size: 18px;
  margin-bottom: 20px;
}

.hero-text button {
  padding: 5px 10px;
  background-color: white;
  color: black;
  border: none;
  border-radius: 20px;
  cursor: pointer;
}

.hero {
  margin-bottom: 0;
}

section.hero {
  margin-bottom: 0;
}


footer { 
    background: #3c1f0d; 
    color: white;
    padding: 32px 16px; 
    margin-top: 48px; 
  } 
   
  .footer-top { 
    margin-bottom: 32px; 
    margin-left: 32px; 
    margin-top: 0;
  } 
   
  .footer-top .logo { 
    font-family: 'Brush Script MT', cursive; 
    font-size: 50px; 
    margin-bottom: 4.8px; 
  } 
  .copyright{
    margin-left: 32px; 
  }
   
  .footer-links { 
    display: flex;
  justify-content: center; 
  align-items: center;
  margin: 30px 0;
  width: 100%;
  } 
   
  .footer-btn { 
  background: white;
  color: #3c1f0d;
  border: none;
  padding: 9.6px 40px;
  border-radius: 20px;
  font-weight: bold;
  cursor: pointer;
  text-decoration: none;
  margin: 0 20px; 
  min-width: 200px; 
  text-align: center;
  } 

  .footer-btn:hover { 
    background: #e2e2e2; 
  } 
   
  footer p { 
    font-size: 10px; 
  }

  footer {
  margin-top: 0;
  }
  </style>
<body>
    <header>
        <div class="logo">Coffee Shop</div>
        <nav>
            <a href="product/product1.jsp">Products</a>
            <a href="/shopping_cart.jsp">Checkout</a>
            <a href="./login.jsp">Login</a>
        </nav>
        
    </header>

  <section class="hero">
    <div class="hero-text">
      <h1>DISCOVER<br>NEW<br>FLAVOURS</h1>
      <p>Coffee always sounds like a brilliant idea.</p>
     <!--<a href="../product_1/product1.html" class="button-link">Shop All Products ></a>-->
      <button onclick="window.location.href='../product/product1.html'" class="shop-button">
  Shop All Products >
</button>
    </div>
  </section>

  <footer>
        <div class="footer-top">    
            <div class="logo">Coffee Shop</div>  
            <p>one Stop | one Heart | one Cup</p>
           
        </div>
      
  <div class="footer-links">
  <a href="#" class="footer-btn" data-page="OurCoffeeShop.html">Our Coffee Shop</a>
  <a href="#" class="footer-btn" data-page="OurCoffeBeans.html">Our Coffee Beans</a>
  <a href="#" class="footer-btn" data-page="Our Pastry.html">Our Pastry</a>
</div>
       </div>
        <p class="copyright">© 2023 All Rights Reserved</p>
    </footer>
      <script src="script.js"></script>

</body>
</html>
