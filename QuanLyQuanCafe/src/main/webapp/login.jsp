<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Coffee Shop - Sign In</title>
    <link rel="stylesheet" href="style_login.css" />
    
</head>
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
   
  main { 
    text-align: center; 
    padding: 16px; 
  } 
   
  h1 { 
    font-size: 32px; 
    margin-bottom: 24px; 
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
   
  .forgotpass { 
    display: block; 
    text-align: left; 
    color: darkgreen; 
    text-decoration: none; 
    font-weight: bold; 
  } 
  
  .createAccount{ 
    display: block; 
    text-align: left; 
    margin-bottom: 24px; 
    color: darkgreen; 
    text-decoration: none; 
    font-weight: bold; 
  } 
   
  .signin-btn { 
    width: 100%; 
    padding: 12px; 
    border: 2px solid #3c1f0d; 
    background: white; 
    border-radius: 20px; 
    font-weight: bold; 
    cursor: pointer; 
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


.shop-button {
  background-color: #6f4e37;    
  color: white;                 
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  font-weight: bold;
  font-size: 16px;
  cursor: pointer;
  text-decoration: none;
  transition: background-color 0.3s ease;
}

.shop-button:hover {
  background-color: #5c3c28;   
}

	</style>
<body>
    <header>
         <a class="logo" href="../home_Shoppingcart/index.html">Coffee Shop</a>
      <nav>
            <a href="../product/product1.html">Products</a>
            <a href="../Shopping_Cart/shopping_cart.html">Checkout</a>
        
        </nav>
    </header>

    <main>
        <h1>Sign in</h1>
        <form class="login-box" action="login" method="post">
            <p><span class="required">*</span> indicates required field</p>
            <input type="text" name="usernameOrEmail" placeholder="*  Username or email address" required />
            <input type="password" name="password" placeholder="*  Password" required />

            <div class="remember">
                <input type="checkbox" id="keep-signed-in" name="keepSignedIn" value="true" />
                <label for="keep-signed-in">Keep me signed in</label>
            </div>
            
            <a href="forgotPass.jsp" class="forgotpass">Forgot your password?</a> <br>
            <a href="createAccount.jsp" class="createAccount">You don't have an account yet?</a>
            <button type="submit" class="signin-btn">Sign in</button>
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
        <p class="copyright">© 2023 All Rights Reserved</p>
    </footer>

        
     <!-- Thêm đoạn script này vào cuối file login.html, trước thẻ </body> -->
<script>
document.addEventListener('DOMContentLoaded', function() {
    // Kiểm tra thông báo lỗi từ URL
    const urlParams = new URLSearchParams(window.location.search);
    if (urlParams.has('error')) {
        const error = urlParams.get('error');
        if (error === 'empty') {
            alert('Vui long nhap ten dang nhap, email va mat khau');
        } else if (error === 'invalid') {
            alert('Ten dang nhap, hoac email khong dung');
        }
    }
    
    // Kiểm tra thông báo đăng ký thành công
    if (urlParams.has('registered') && urlParams.get('registered') === 'true') {
        const username = urlParams.get('username');
        alert('Dang ky thanh cong, ten dang nhap cua ban la: ' + username);
    }
});
</script>
</body>
    
</html>