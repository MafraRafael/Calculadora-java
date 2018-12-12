/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Modelo.Calculadora;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mafra
 */
@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @return
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected String processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Calculadora calc = new Calculadora();

        int Num1 = Integer.parseInt(request.getParameter("Num1"));

        int Num2 = Integer.parseInt(request.getParameter("Num2"));

        int resultado = 0;

        String op = request.getParameter("op");

        switch (op.charAt(0)) {

            case '+':

                System.out.println("o resultado é:" + calc.somar(Num1, Num2));

                resultado = calc.somar(Num1, Num2);

                break;

            case '-':

                System.out.println("o resultado é:" + calc.subtrair(Num1, Num2));

                resultado = calc.subtrair(Num1, Num2);

                break;

            case '*':

                System.out.println("o resultado é:" + calc.multiplicar(Num1, Num2));

                resultado = calc.multiplicar(Num1, Num2);

                break;

            case '/':

                System.out.println("o resultado é:" + calc.dividir(Num1, Num2));

                resultado = calc.dividir(Num1, Num2);

                break;

        }

        String resposta = "Resposta = " + resultado;

        request.setAttribute("resposta", resposta);

        RequestDispatcher rp = request.getRequestDispatcher("SaidaNumero.jsp");

        rp.forward(request, response);

        // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
        /**
         * Handles the HTTP <code>GET</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        void doGet
        (HttpServletRequest request = null, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Handles the HTTP <code>POST</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        void doPost
        (HttpServletRequest request = null, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
