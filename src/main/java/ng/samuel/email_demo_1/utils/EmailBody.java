package ng.samuel.email_demo_1.utils;

public class EmailBody {


    public static String buildEmail(String name, String lastName, String link) {

            return "<!DOCTYPE html>\n" +
                    "<html xmlns:th=\"http://www.thymeleaf.org\" lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Email Verification</title>\n" +
                    "    <style>\n" +
                    "        /* Reset CSS */\n" +
                    "        body, h1, p {\n" +
                    "            margin: 0;\n" +
                    "            padding: 0;\n" +
                    "        }\n" +
                    "\n" +
                    "        body {\n" +
                    "            font-family: Arial, sans-serif;\n" +
                    "            line-height: 1.6;\n" +
                    "        }\n" +
                    "\n" +
                    "        /* Email wrapper */\n" +
                    "        .email-wrapper {\n" +
                    "            max-width: 600px;\n" +
                    "            margin: 0 auto;\n" +
                    "            padding: 20px;\n" +
                    "        }\n" +
                    "\n" +
                    "        /* Header */\n" +
                    "        .header {\n" +
                    "            background-color: #007bff;\n" +
                    "            color: white;\n" +
                    "            text-align: center;\n" +
                    "            padding: 20px 0;\n" +
                    "        }\n" +
                    "\n" +
                    "        /* Content */\n" +
                    "        .content {\n" +
                    "            padding: 20px;\n" +
                    "            background-color: #f9f9f9;\n" +
                    "            border-radius: 8px;\n" +
                    "        }\n" +
                    "\n" +
                    "        /* Button */\n" +
                    "        .btn {\n" +
                    "            display: inline-block;\n" +
                    "            background-color: #d0dbe7;\n" +
                    "            color: black;\n" +
                    "            text-decoration: none;\n" +
                    "            padding: 10px 20px;\n" +
                    "            border-radius: 5px;\n" +
                    "            margin-top: 20px;\n" +
                    "            margin-bottom: 20px;\n" +
                    "        }\n" +
                    "\n" +
                    "        /* Footer */\n" +
                    "        .footer {\n" +
                    "            text-align: center;\n" +
                    "            margin-top: 20px;\n" +
                    "            font-size: 12px;\n" +
                    "            color: #666;\n" +
                    "        }\n" +
                    "\n" +
                    "        /* Media Queries */\n" +
                    "        @media screen and (max-width: 600px) {\n" +
                    "            .email-wrapper {\n" +
                    "                width: 100%;\n" +
                    "            }\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class=\"email-wrapper\">\n" +
                    "    <!-- Header -->\n" +
                    "    <div class=\"header\">\n" +
                    "        <h1>Email Verification</h1>\n" +
                    "    </div>\n" +
                    "\n" +
                    "    <!-- Content -->\n" +
                    "    <div class=\"content\">\n" +
                    "        <p>Hello " + name +" "+ lastName + ",</p>\n" +
                    "        <p>Welcome to Task Management Application by <strong>POD-A SQ022</strong> Decagon Institute. Click the button below to verify your email address </p><br><p>Link Expires in Ten Minutes. After Which you Have to Register Again</p> \n" +
                    "        <a href=\""+ link +"\" class=\"btn\">Verify Email</a>\n" +
                    "        <p>If you did not create an account, please ignore this email.</p>\n" +
                    "    </div>\n" +
                    "\n" +
                    "    <!-- Footer -->\n" +
                    "    <div class=\"footer\">\n" +
                    "        <p>This email was sent from &copy;<b>sq022-POD-A</b>.</p>\n" +
                    "    </div>\n" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>";
        }

    }

