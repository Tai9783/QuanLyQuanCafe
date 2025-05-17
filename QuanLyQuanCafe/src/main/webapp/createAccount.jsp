<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Coffee Shop - Create Account</title>
  <style>
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
      font-family: Arial, sans-serif;
    }

    body {
      background: #fff;
      color: #000;
    }

    header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      background: #3c1f0d;
      color: white;
      padding: 16px 32px;
    }

    .logo {
      font-family: 'Brush Script MT', cursive;
      font-size: 28.8px;
      color: white;
      text-decoration: none;
    }

    header nav a {
      margin-left: 32px;
      color: white;
      text-decoration: none;
      font-weight: bold;
    }

    main {
      padding: 16px;
    }

    h1 {
      text-align: center;
      font-size: 32px;
      margin-bottom: 24px;
    }

    .createAccount-box {
      width: 90%;
      max-width: 400px;
      margin: 0 auto;
      padding: 32px;
      border: 2px solid #444;
      border-radius: 10px;
    }

    .createAccount-box p {
      margin-bottom: 12px;
      font-size: 14px;
    }

    .createAccount-box b {
      display: block;
      margin-top: 20px;
      margin-bottom: 10px;
    }

    .required {
      color: green;
    }

    .createAccount-box input {
      width: 100%;
      padding: 12px;
      margin-bottom: 16px;
      border: 1px solid #aaa;
      border-radius: 8px;
      font-size: 16px;
    }

    .remember {
      display: flex;
      align-items: center;
      margin-bottom: 16px;
    }

    .remember input[type="checkbox"] {
      width: 18px;
      height: 18px;
      margin-right: 10px;
      accent-color: green;
    }

    .remember label {
      font-weight: bold;
    }

    .create {
      width: 100%;
      padding: 12px;
      border: 1px solid #000000;
      background: #43793B;
      border-radius: 20px;
      font-weight: bold;
      color: #fff;
      cursor: pointer;
    }

    .create:hover {
      background: #285521;
    }

    .back-button {
      display: inline-block;
      margin-top: 10px;
      color: #333;
      text-decoration: none;
    }

    .back-button::before {
      content: "←";
      margin-right: 5px;
      font-size: 16px;
    }

    footer {
      background: #3c1f0d;
      color: white;
      padding: 32px 16px;
      margin-top: 48px;
    }

    .footer-top {
      margin-left: 32px;
      margin-bottom: 32px;
    }

    .footer-top .logo {
      font-family: 'Brush Script MT', cursive;
      font-size: 50px;
    }

    .footer-links {
      display: flex;
      justify-content: center;
      align-items: center;
      margin: 30px 0;
    }

    .footer-btn {
      background: white;
      color: #3c1f0d;
      border: none;
      padding: 10px 40px;
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

    .copyright {
      margin-left: 32px;
      font-size: 10px;
    }
  </style>
</head>

<body>
  <header>
    <a class="logo" href="../home_Shoppingcart/index.html">Coffee Shop</a>
    <nav>
      <a href="../product/product1.html">Products</a>
      <a href="../Shopping_Cart/shopping_cart.html">Checkout</a>
      <a href="../XuLy_PhanLogin/login.html">Login</a>
    </nav>
  </header>

  <main>
    <h1>Create an Account</h1>
   <form class="createAccount-box" action="register" method="post">
  <p><span class="required">*</span> indicates required field</p>

  <b>* Username</b>
  <input type="text" name="username" placeholder="Enter username" required />

  <b>* Password</b>
  <input type="password" name="password" placeholder="Enter password" required />
  <p>Create a password 5 to 25 characters long that includes at least
    1 uppercase, 1 lowercase letter, 1 number, and 1 special character.</p>

  <b>* Email</b>
  <input type="text" name="email" placeholder="Enter email address" required />

  <b>* Address</b>
  <input type="text" name="address" placeholder="Enter address" required />

  <b>* Phone Number</b>
  <input type="text" name="phone" placeholder="Enter phone number" required />

  <div class="remember">
    <input type="checkbox" id="agree" name="agree" value="true" required />
    <label for="agree"><span class="required">*</span> I agree to the terms of Coffee Shop</label>
  </div>

  <button type="submit" class="create">Create account</button>
  <a href="login.jsp" class="back-button">Back to login</a>
</form>
  </main>

  <footer>
    <div class="footer-top">
      <div class="logo">Coffee Shop</div>
      <p>one Stop | one Heart | one Cup</p>
    </div>

    <div class="footer-links">
      <a href="../GioiThieu_Quan/OurCoffeeShop.html" class="footer-btn">Our Coffee Shop</a>
      <a href="../GioiThieu_Quan/OurCoffeBeans.html" class="footer-btn">Our Coffee Beans</a>
      <a href="../GioiThieu_Quan/OurPastry.html" class="footer-btn">Our Pastry</a>
    </div>

    <p class="copyright">© 2023 All Rights Reserved</p>
  </footer>
  <!-- Thêm đoạn script này vào cuối file createAccount.jsp, trước thẻ </body> -->
<script>
document.addEventListener('DOMContentLoaded', function() {
    const registerForm = document.querySelector('form.createAccount-box');
    
    registerForm.addEventListener('submit', function(e) {
        // Không ngăn chặn form submit mặc định
        // e.preventDefault();
        
        const username = registerForm.querySelector('input[name="username"]').value;
        const password = registerForm.querySelector('input[name="password"]').value;
        const email = registerForm.querySelector('input[name="email"]').value;
        const address = registerForm.querySelector('input[name="address"]').value;
        const phone = registerForm.querySelector('input[name="phone"]').value;
        const agree = registerForm.querySelector('input[name="agree"]').checked;
        
        if (!agree) {
            alert('Vui lòng đồng ý với điều khoản của Coffee Shop');
            e.preventDefault();
            return;
        }
        
        console.log("Form submitted with data:");
        console.log("Username: " + username);
        console.log("Email: " + email);
        console.log("Address: " + address);
        console.log("Phone: " + phone);
    });
    
    // Kiểm tra thông báo lỗi từ URL
    const urlParams = new URLSearchParams(window.location.search);
    if (urlParams.has('error')) {
        const error = urlParams.get('error');
        if (error === 'empty') {
            alert('Vui lòng điền đầy đủ thông tin bắt buộc!');
        } else if (error === 'username_exists') {
            alert('Tên đăng nhập đã tồn tại!');
        } else if (error === 'email_exists') {
            alert('Email đã tồn tại!');
        } else if (error === 'failed') {
            alert('Đăng ký thất bại. Vui lòng thử lại sau!');
        } else if (error === 'system') {
            alert('Lỗi hệ thống: ' + urlParams.get('message'));
        }
    }
});
</script>
</body>
</html>
