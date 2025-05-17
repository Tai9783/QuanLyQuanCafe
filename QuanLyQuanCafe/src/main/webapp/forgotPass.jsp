<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Coffee Shop - Sign In</title>
   
</head>

<style>
    * { 
    box-sizing: border-box; 
    margin: 0; 
    padding: 0; 
    font-family: Arial, sans-serif; 
  } 
   
  .logo {
  font-family: 'cursive';
  font-size: 24px;
  color: white;
  text-decoration: none; 
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
   
  main { 
    
    padding: 16px; 
  } 
   
  h1 { 
    font-size: 32px; 
    margin-bottom: 24px; 
    text-align: center;
  } 
   
  .login-box { 
    width: 90%; 
    max-width: 400px; 
    margin: 0 auto; 
    padding: 32px; 
    border: 2px solid #444; 
    border-radius: 10px; 
  } 
   
  .login-box p { 
    text-align: left; 
    margin-bottom: 16px; 
    font-size: 14.4px; 
  } 
   .text{
    display: block;
    color: #5F5F5F;
   }
   .login-box a{
    display: block;
      text-decoration: none;
      color: #000;
      text-align: left;
   }
   .create{
   
    width: 100%; 
    padding: 12px; 
    border: 1px solid #000000; 
    background: #43793B; 
    border-radius: 20px; 
    font-weight: bold; 
   color: #fff;
  
    }
   
    .create:hover {
      background: #285521;
    }
    .anh{
      width: 7%;
     margin-top: 16px;
    
    }
      .back-button {
      display: inline-flex;
      align-items: center;
      font-family: Arial, sans-serif;
      font-size: 14px;
      color: #333;
      text-decoration: none;
      padding: 8px 0;
      margin: 10px 0;
      cursor: pointer;
      border: none;
      background: transparent;
    }
    
    .back-button::before {
      content: "←";
      margin-right: 5px;
      font-size: 16px;
    }




  .required { 
    color: green; 
  } 
   
  .login-box input[type="text"], 
  .login-box input[type="password"] { 
    width: 100%; 
    padding: 12px; 
    margin-bottom: 16px; 
    border: 1px solid #aaa; 
    border-radius: 8px; 
    font-size: 16px; 
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
  
</style>
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
        <h1>Forgot password</h1>
        <form class="login-box" action="forgot-password" method="post">
            <p><span class="required">*</span> indicates required field</p>
            <p class="text">Just need to confirm your email to send you instructions to reset your password.</p>
            <input type="text" name="email" placeholder="*  Email address" required />

            <button type="submit" class="create">Reset password</button>
            
                 <a href="./login.jsp" class="back-button">Back to</a> 
           
            
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
       </div>
  </div>


        <p class="copyright">© 2023 All Rights Reserved</p>
    </footer>
   

    <!-- Thêm đoạn script này vào cuối file forgotPass.html, trước thẻ </body> -->
<script>
document.addEventListener('DOMContentLoaded', function() {
    // Kiểm tra thông báo lỗi từ URL
    const urlParams = new URLSearchParams(window.location.search);
    if (urlParams.has('error')) {
        const error = urlParams.get('error');
        if (error === 'empty') {
            alert('Vui Long Nhap Dia Chi Email');
        } else if (error === 'notfound') {
            alert('Email nay khong ton tai trong he thong');
        } else if (error === 'failed') {
            alert('Khong the dat lai mat khau. Vui long thu lai sau');
        }
    }
});
</script>

</body>

</html>