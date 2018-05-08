<html>
    <head>
    <title>
        Hello World
    </title>
    </head>
    <body>
        <table>
            <?php
                require_once "common.php";
                // $word = 'apple';
                // for($i = 0; $i<strlen($word);$i++){
                //     echo "$word[$i]<br>";
                // }
                // $new = ['Hello','Bye'];
                // echo "<table><tr><td>$new[0]</td></tr><tr><td>$new[1]</td></tr></table>";
                // echo "<tr>
                //         <td>";
                if(isset($_POST['user'])){
                    echo "Username: {$_POST['user']} <br>";
                } else{
                    echo "There is no POST<br>";
                }
                echo "  </td>
                      </tr>";
                echo "<tr>
                        <td>";
                if(isset($_GET['user'])){
                    echo "Username: {$_GET['user']}<br>";
                } else{
                    echo "There is no GET<br>";
                }
                echo "  </td>
                      </tr>";
            ?>
        </table>
        <br><br>
        <form method = 'post' action="hello.php">
            <table>
                <tr>
                    <th colspan = 2>
                        POST Request
                    </th>
                </tr>
                <tr>
                    <td>
                        Username: <input type = "text" name = "user"/>
                    </td>
                    <td>
                        Password: <input type = "password" name = "pass"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type='submit' value='Go'/>
                    </td>
                </tr>
            </table>
        </form>
            <br>
            <br>
        <form method = 'get' action="hello.php">
            <table>
                <tr>
                    <th colspan = 2>
                        GET Request
                    </th>
                </tr>
                <tr>
                    <td>
                        Username: <input type = "text" name = "user"/>
                    </td>
                    <td>
                        Password: <input type = "password" name = "pass"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type='submit' value='Go'/>
                    </td>
                </tr>
            </table>
            <img src="lion.jpg">
        </form>
    </body>
</html>