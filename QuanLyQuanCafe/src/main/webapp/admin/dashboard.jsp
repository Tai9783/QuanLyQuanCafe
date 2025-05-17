<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard - Coffee Shop</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }
        
        body {
            background: #f4f4f4;
            color: #333;
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
        
        nav a {
            margin-left: 32px;
            color: white;
            text-decoration: none;
            font-weight: bold;
        }
        
        .container {
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
            background: white;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        
        h1 {
            color: #3c1f0d;
            margin-bottom: 20px;
        }
        
        .dashboard-stats {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
            margin-bottom: 30px;
        }
        
        .stat-card {
            background: #f9f9f9;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            text-align: center;
        }
        
        .stat-card h2 {
            font-size: 36px;
            color: #3c1f0d;
            margin-bottom: 10px;
        }
        
        .stat-card p {
            color: #666;
            font-size: 14px;
        }
        
        .recent-orders {
            margin-top: 30px;
        }
        
        table {
            width: 100%;
            border-collapse: collapse;
        }
        
        table th, table td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        
        table th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        
        .btn {
            display: inline-block;
            padding: 8px 16px;
            background: #3c1f0d;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            font-size: 14px;
        }
        
        .btn:hover {
            background: #2a1508;
        }
        
        .logout-btn {
            background: #d9534f;
        }
        
        .logout-btn:hover {
            background: #c9302c;
        }
    </style>
</head>
<body>
    <header>
        <a href="#" class="logo">Coffee Shop Admin</a>
        <nav>
            <a href="#">Dashboard</a>
            <a href="#">Products</a>
            <a href="#">Orders</a>
            <a href="#">Users</a>
            <a href="logout" class="btn logout-btn">Logout</a>
        </nav>
    </header>
    
    <div class="container">
        <h1>Admin Dashboard</h1>
        
        <div class="dashboard-stats">
            <div class="stat-card">
                <h2>0</h2>
                <p>Total Orders</p>
            </div>
            <div class="stat-card">
                <h2>0</h2>
                <p>Total Products</p>
            </div>
            <div class="stat-card">
                <h2>0</h2>
                <p>Total Users</p>
            </div>
            <div class="stat-card">
                <h2>$0</h2>
                <p>Total Revenue</p>
            </div>
        </div>
        
        <div class="recent-orders">
            <h2>Recent Orders</h2>
            <table>
                <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>Customer</th>
                        <th>Date</th>
                        <th>Amount</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td colspan="6" style="text-align: center;">No orders found</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    
    <script>
        // Kiểm tra nếu người dùng không phải admin thì chuyển hướng về trang login
        document.addEventListener('DOMContentLoaded', function() {
            <% 
            // Kiểm tra session
            if (session.getAttribute("user") == null || !((com.quantyquancafe.model.User)session.getAttribute("user")).isAdmin()) {
                response.sendRedirect("../login.jsp");
                return;
            }
            %>
            
            console.log("Admin dashboard loaded");
        });
    </script>
</body>
</html>