function checkExist(){
                var xmlhttp = new XMLHttpRequest();
                var username = document.forms["SigUp"]["username"].value;
                var url = "/WEB-INF/mainPages/IsUserExists.jsp?username=" + username;
                xmlhttp.onreadystatechange = function(){
                    if(xmlhttp.readyState == 4 && xmlhttp.status == 200)
                    {
                        if(xmlhttp.responseText == "\n\n\n\n\nUser already exists")
                            document.getElementById("isE").style.color = "red";
                        else
                            document.getElementById("isE").style.color = "green";
                        document.getElementById("isE").innerHTML = xmlhttp.responseText;
                    }
                    
                };
                try
                {
                xmlhttp.open("GET",url,true);
                xmlhttp.send();
            }catch(e)
            {
            	alert("unable to connect to server");
            }
            }