<!DOCTYPE html>
<html>
<head>
    <title>Student Attendance Portal</title>
    <style>
        body {
            font-family: Arial;
            background-color: #f2f2f2;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        form {
            background: #fff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px gray;
        }
        input, select {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
        }
        input[type="submit"] {
            background-color: #0078d7;
            color: white;
            border: none;
            cursor: pointer;
            font-weight: bold;
        }
        input[type="submit"]:hover {
            background-color: #005fa3;
        }
        h2 {
            text-align: center;
        }
    </style>
</head>
<body>
    <form action="AttendanceServlet" method="post">
        <h2>Student Attendance Portal</h2>
        Student ID: <input type="text" name="studentId" required><br>
        Student Name: <input type="text" name="studentName" required><br>
        Date: <input type="date" name="date" required><br>
        Status:
        <select name="status" required>
            <option value="">--Select--</option>
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select><br>
        <input type="submit" value="Submit Attendance">
    </form>
</body>
</html>
