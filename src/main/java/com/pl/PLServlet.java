package com.pl;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PLServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            int cp = Integer.parseInt(req.getParameter("costPrice"));
            int sp = Integer.parseInt(req.getParameter("sellingPrice"));

            String message;
            String color;

            if (sp > cp) {
                int profit = sp - cp;
                message = "Profit: " + profit;
                color = "#28a745"; // Green for profit
            } else if (cp > sp) {
                int loss = cp - sp;
                message = "Loss: " + loss;
                color = "#dc3545"; // Red for loss
            } else {
                message = "No Profit, No Loss";
                color = "#007bff"; // Blue for neutral
            }

            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Profit or Loss Result</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
            out.println(".container { background: #ffffff; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); padding: 20px; text-align: center; }");
            out.println("h1 { font-size: 24px; color: #333333; margin-bottom: 20px; }");
            out.println(".result { font-size: 20px; font-weight: bold; color: " + color + "; margin-top: 20px; }");
            out.println("a { text-decoration: none; color: #007bff; font-size: 16px; margin-top: 20px; display: inline-block; }");
            out.println("a:hover { text-decoration: underline; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>Profit or Loss Calculation Result</h1>");
            out.println("<div class='result'>" + message + "</div>");
            out.println("<a href='/ProfitOrLoss'>Back to Form</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } catch (NumberFormatException e) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Error</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
            out.println(".container { background: #ffffff; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); padding: 20px; text-align: center; }");
            out.println("h1 { font-size: 24px; color: #333333; margin-bottom: 20px; }");
            out.println(".error { font-size: 20px; font-weight: bold; color: #dc3545; margin-top: 20px; }");
            out.println("a { text-decoration: none; color: #007bff; font-size: 16px; margin-top: 20px; display: inline-block; }");
            out.println("a:hover { text-decoration: underline; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>Error</h1>");
            out.println("<div class='error'>Please enter valid numeric values for cost price and selling price.</div>");
            out.println("<a href='/ProfitOrLoss'>Back to Form</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}
