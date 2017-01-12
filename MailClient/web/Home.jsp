

<html> 
    <title>Home</title>
    <style type="text/css">
        #wrapper
        {
            height:650px;
            width:1300px;
        }   

        input[type=text], select 
        {
            padding: 8px 25px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=password], select 
        {
            padding: 8px 25px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=number], select 
        {
            padding: 8px 25px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] 
        {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        

        input[type=submit] 
        {
            background-color: #45a049;
            padding: 15px;
        }

        #form
        {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
            height:650px;
            width:400px;
            float: right;
        }

        #account
        {
            border-radius: 5px;
            background-color: #f2f299;
            padding: 20px;
            width: 810px;
            height: 650px;
            float: left;
        }

        .message1
        {
            color: red;
            font-size: small;
            font-family: Times New Roman;
        }

        .message2
        {
            color: blue;
            font-size: 35;
            font-family: Copperplate Gothic Bold;
        }

        .message3
        {
            color: black;
            font-size: 50;
            font-family: Bodoni MT Black;
            padding-left: 150px; 
        }

        div
        {

        }
      </style>
      <head>
        <script>
            function validation()
            {
                var Fname=document.getElementById("fname").value;
                var Lname=document.getElementById("lname").value;
                var Uname=document.getElementById("uname").value;
                var Password=document.getElementById("password").value;
                var Cpassword=document.getElementById("cpassword").value;
                var Mobile=document.getElementById("mobile").value;
                var Day=document.getElementById("day").value;
                var Month=document.getElementById("month").value;
                var Year=document.getElementById("year").value;
                var Male=document.getElementById("gender").checked;
                var Female=document.getElementById("gender").checked;
                var Other=document.getElementById("gender").checked;
                var Country=document.getElementById("country").value;
                
                if(Fname=="")
                {
                    alert("Enter First Name");
                    return false;
                }
                if(Lname=="")
                {
                    alert("Enter Last Name");
                    return false;
                }   
                if(Uname=="")
                {
                    alert("Enter User Name");
                    return false;
                }
                if(Password=="")
                {
                    alert("Enter Your Password");
                    return false;
                }
                if(Cpassword=="")
                {
                    alert("Confirm Your Password");
                    return false;
                }
                if(Mobile=="")
                {
                    alert("Confirm Your mobile");
                    return false;
                }
                if(Day=="day")
                {
                    alert("Enter the Date");
                    return false;
                } 
                if(Month=="month")
                {
                    alert("Enter the Month");
                    return false;
                } 
                if(Year=="")
                {
                    alert("Enter the Year");
                    return false;
                } 
                if(Male=="" && Female=="" && Other=="")
                {
                    alert("Ente Your Gender");
                    return false;
                }
                if(Country=="")
                {
                    alert("Ente Your Countery Name");
                    return false;
                }
            }
        </script>
      </head>
    <body>


        <div id="wrapper" >
            
            <div id="account" >
                <text class="message3">Already Registered?</text>
                <br>
                <form action="Login" method="post">
                    <center><label for="uname">User name</label>
                        <input type="text" id="uname" name="username" placeholder="your user Name">
                    </center>
                    <br> 
                    <center><label for="pasword">Password</label>
                        <input type="password" id="pasword" name="pasword">
                    </center>
                    <br>
                    <center><input type="submit" value="Login"></center>
                </form>
            </div>



            <div id="form" action="Registration" method="post">
                <form action="Registration" method="post" >
                    <text class="message2">Register Here</text>
                    <br>
                    <label for="fname">First Name</label>
                    <input type="text" id="fname" name="fname">
                    <br>
                    <label for="lname">Last Name</label>
                    <input type="text" id="lname" name="lname">
                    <br>

                    <label for="uname">User name</label>
                    <input type="text" id="uname" name="uname" placeholder="username@xmail.com">
                    <br>

                    <label for="pasword">Password</label>
                    <input type="password" id="password" name="pasword">
                    <br>

                    <label for="cpassword">Confirm Password</label>
                    <input type="password" id="cpassword" name="cpassword">
                    <br>

                    <label for="mobile">Mobile</label>
                    <input type="number" id="mobile" name="mobile">
                    <br>

                    <label for="dob">Date of Birth</label>
                    <input type="number" id="day"  name="day" placeholder="DAY">
                    <input type="number" id="month"  name="month" placeholder="MONTH(numeric)">
                    <input type="number" id="year"  name="year" placeholder="YEAR">
                    <br>

                    <label for="gender">Gender</label>
                    <select id="gender" name="gender">
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                        <option value="other">Other</option>
                    </select>

                    <label for="country">Country</label>
                    <select id="country" name="country">
                        <option value="australia">Australia</option>
                        <option value="canada">Canada</option>
                        <option value="usa">USA</option>
                        <option value="india">India</option>
                    </select>
                    <br>
                    <label for="image">Image</label>
                    <input type="file">
                    <br>
                    <text class="message1">All fields are mandatory </text>
                    <br>
                    <input type="submit" value="Submit" >
                </form>
            </div>
        </div>

    </body>
</html>
