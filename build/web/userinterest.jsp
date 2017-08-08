<!DOCTYPE html>

<head>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <style>
        #banner {
            width: 100%;
            height: auto;
        }

        .nav {
            background-color: #1976d2 !important;
        }
        /* label color */
        .input-field label {
            color: #01579b;
        }
        /* label focus color */
        .input-field input[type=text]:focus + label {
            color: #00b0ff;
        }
        /* label underline focus color */
        .input-field input[type=text]:focus {
            border-bottom: 1px solid #00b0ff;
            box-shadow: none;
        }
        .input-field input[type=email]:focus + label {
            color: #00b0ff;
        }
        /* label underline focus color */
        .input-field input[type=email]:focus {
            border-bottom: 1px solid #00b0ff;
            box-shadow: none;
        }
        /* label focus color */
        .input-field input[type=password]:focus + label {
            color: #00b0ff;
        }
        /* label underline focus color */
        .input-field input[type=password]:focus {
            border-bottom: 1px solid #00b0ff;
            box-shadow: none;
        }
        .input-field input[type=number]:focus + label {
            color: #00b0ff;
        }
        /* label underline focus color */
        .input-field input[type=number]:focus {
            border-bottom: 1px solid #00b0ff;
            box-shadow: none;
        }
    </style>
</head>

<body>

    <nav class="light-blue darken-4">
        <div class="nav-wrapper container">
            <a href="#" class="brand-logo "><img src="logo.png" class="center" height="50" style="margin: 5%"></a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="index.html">Login</a></li>
                <li><a href="about.html">About</a></li>
            </ul>
        </div>
    </nav>
    <div>
        <img id="banner" src="banner3.png">
    </div>
    <div class="container" style="padding-left: 200px; padding-right: 200px">
        <form class="col s12" method="post" action="userint">
            <div class="card-panel z-depth-2" style="padding: 20px 80px 20px 80px">
                <h4 class="light-blue-text text-darken-4 center"><b>SIGNUP</b></h4><br>
                <h5 class="light-blue-text text-darken-4 center"><b>Personal Interest</b></h5>
                <h6 class="light-blue-text text-darken-4 center">(Step -> 3 of 3)</h6><br>
                <div style="padding: 20px 0px 20px 30%">
                    <div class="row">
                        <div class="input-field col s12  ">
                            <input type="checkbox" class="filled-in" id="sports" name="sports" />
                            <label for="sports">Sports</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12  ">
                            <input type="checkbox" class="filled-in" id="reading" name="reading" />
                            <label for="reading">Reading</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12  ">
                            <input type="checkbox" class="filled-in" id="computer" name="computer" />
                            <label for="computer">Computer and Software</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12  ">
                            <input type="checkbox" class="filled-in" id="songs" name="songs" />
                            <label for="songs">Songs</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12  ">
                            <input type="checkbox" class="filled-in" id="dance" name="dance"  />
                            <label for="dance">Dance</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12  ">
                            <input type="checkbox" class="filled-in" id="photography" name="photography"  />
                            <label for="photography">Photography</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12  ">
                            <input type="checkbox" class="filled-in" id="fashion" name="fashion"  />
                            <label for="fashion">Fashion</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12  ">
                            <input type="checkbox" class="filled-in" id="painting" name="painting"  />
                            <label for="painting">Painting</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12  ">
                            <input type="checkbox" class="filled-in" id="traveling" name="traveling"  />
                            <label for="traveling">Traveling</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12  ">
                            <input type="checkbox" class="filled-in" id="writing" name="writing"  />
                            <label for="writing">Writing</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12  ">
                            <input type="checkbox" class="filled-in" id="gaming" name="gaming"  />
                            <label for="gaming">Gaming</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12  ">
                            <input type="checkbox" class="filled-in" id="cooking" name="cooking"  />
                            <label for="cooking">Cooking</label>
                        </div>
                    </div>
                    <input type="hidden" name="email" value="<%= request.getParameter("email")%>">
                </div>   
                <br>
                <div class="center">
                    <button class="btn waves-effect waves-light light-blue darken-4 z-depth-2" type="submit" name="action" style="margin-left: 30px">Sign Me upon
                        <i class="fa fa-fighter-jet right" aria-hidden="true"></i>
                    </button>
                </div>
                <br>
            </div>
        </form>
    </div>
    <footer class="page-footer light-blue darken-4">
        <div class="footer-copyright">
            <div class="container">
                © 2017 Copyright &emsp; &emsp; &emsp; &emsp; Made with <i class="fa fa-heart" aria-hidden="true"></i>	 while drinking <i class="fa fa-coffee" aria-hidden="true"></i>
                <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
            </div>
        </div>
    </footer>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>

    <script type="text/javascript">
        $('.datepicker').pickadate({
            selectMonths: true, // Creates a dropdown to control month
            selectYears: 15, // Creates a dropdown of 15 years to control year,
            today: 'Today',
            clear: 'Clear',
            close: 'Ok',
            closeOnSelect: false // Close upon selecting a date,
        });
    </script>
</body>
</html>