
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            #wrapper
            {
                height:650px;
                width:1300px;
            } 
            #header
            {
                height:150px;
                width:1300px;
                background:#f2f2f2;
                float:left;
                /*  background-repeat:no-repeat; */

            } 
            #menu
            {
                height:500px;
                width:250px;
                background-color:#f2f299;
                float:left;
            }
            #content
            {
                height:500px;
                width:1050px;
                background-color:floralwhite;
                float:left;
            }
            /*   #comment
               {
                   height:800px;
                   width:190px;
                   background-color:white;
                   float:left;
               }
               #footer
               {
                   height:100px;
                   width:1340px;
                   background-color:linen;
                   float:left;
               }*/

            .button1 
            {
                background-color: brown;
                border: none;
                color: white;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
            }

            .button2 
            {
                background-color: #1E90FF;
                border: none;
                color: white;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
            }

            input[type=submit] 
            {
                background-color: brown;
                color: white;
                padding: 15px 32px;
                margin: 8px 0;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            input[type="file"] {
                display: none;
            }
            .custom-file-upload 
            {
                border: 1px solid #ccc;
                display: inline-block;
                padding: 15px 32px;
                cursor: pointer;
                background-color: yellow;

            }

            .modal 
            {
                display: none; 
                position: fixed; 
                z-index: 1; 
                padding-top: 100px; 
                left: 0;
                top: 0;
                width: 100%; 
                height: 100%; 
                overflow: auto; 
                background-color: rgb(0,0,0); 
                background-color: rgba(0,0,0,0.4); 
            }

            .modal-content 
            {
                background-color: #fefefe;
                margin: auto;
                padding: 20px;
                border: 1px solid #888;
                width: 80%;
            }
            .close 
            {
                color: #aaaaaa;
                float: right;
                font-size: 28px;
                font-weight: bold;
            }
            .close:hover,
            .close:focus 
            {
                color: #000;
                text-decoration: none;
                cursor: pointer;
            }

            input[type=text], select 
            {
                width: 100%;
                padding: 8px 25px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            textarea#styled {
                width: 1000px;
                height: 250px;
                border: 3px solid #cccccc;
                padding: 5px;
                margin: 8px 0;
                font-family: Tahoma, sans-serif;
                background-image: url(bg.gif);
                background-position: bottom right;
                background-repeat: no-repeat;
            }
        </style>
        <script>
            function setbg(color)
            {
                document.getElementById("styled").style.background=color
            }
            
            $("#uploadTrigger").click(function()
            {
                $("#uploadFile").click();
            });
        </script>
        <title>MY PROFILE</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header"></div>
            <div id="menu">
                <form action="" method="post">
                    <center><input type ="button" value ="COMPOSE" class="button1" button id="compose"></center>                
                    <div id="myModal" class="modal">
                        <div class="modal-content">
                            
                         <!--this is popup portion------>   
                            <form action="SendMail" method="post">
                            <span class="close">×</span>
                            <form action="" method="post">
                                <table>  
                                    <tr>
                                        <td>  
                                            <input type="text" name="to_" placeholder="TO:">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td> 
                                            <input type="text" name="subject" placeholder="SUBJECT">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td> 
                                            <textarea name="textArea" id="styled" onfocus="this.value=''; onblur="setbg('white')" placeholder="Enter your text here..."></textarea>
                                        </td>
                                    </tr>
                                </table>

                                <center><input type ="submit" value ="SEND" class="button1">  
                                    <label for="file-upload" class="custom-file-upload">Attachment</label>
                                    <input id="file-upload" type="file"/>
                                </center>
                            </form>
                        </div>
                    </div>
                       <!--popup-->
                    <script>
                           
                        var modal = document.getElementById('myModal');
                        var btn = document.getElementById("compose");
                        var span = document.getElementsByClassName("close")[0];
                        btn.onclick = function() 
                        {
                            modal.style.display = "block";
                        }
                        span.onclick = function() 
                        {
                            modal.style.display = "none";
                        }
                        window.onclick = function(event) 
                        {
                            if (event.target == modal) 
                            {
                                modal.style.display = "none";
                            }
                        }
                    </script>
                </form>

                <center><input type ="button" value ="INBOX    " class="button1" button id="inboxButton"></center>
                <center><input type ="button" value ="OUT BOX" class="button1" button id="outboxButton"></center>
                <center><input type ="button" value ="DRAFT    " class="button1" button id="draftButton"></center>
            </div>
            <div id="content"></div>


        </div>
    </body>
</html>
