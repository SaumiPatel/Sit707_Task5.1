<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Multiplication Question</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            line-height: 1.6;
        }
        h1 {
            color: #333;
        }
        .container {
            max-width: 500px;
            margin: 0 auto;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .error-message {
            color: red;
            margin-top: 15px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Q3</h1>
        <p>Excellent! Now for the final challenge - a multiplication problem:</p>
        
        <form action="/q3" method="post">
            <div class="form-group">
                <label for="number1">First number:</label>
                <input type="text" id="number1" name="number1" required>
            </div>
            <div class="form-group">
                <label for="number2">Second number:</label>
                <input type="text" id="number2" name="number2" required>
            </div>
            <div class="form-group">
                <label for="result">MULTIPLY:</label>
                <input type="text" id="result" name="result" required>
            </div>
            <input type="submit" value="Submit">
        </form>
        
        <div class="error-message">
            ${message}
        </div>
    </div>
</body>
</html>