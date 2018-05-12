<?php
    if (!empty($argv)) {
        $requestMethod = $argv[1];
        $getFormdata = $argv[2];

        if($requestMethod == "POST"){

            parse_str($getFormdata, $_POST);

        } else if ($requestMethod == "GET"){

            parse_str($getFormdata, $_GET);

        }
    }
?>