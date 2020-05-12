/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Объявляем servlet.
@WebServlet(name = "CustomerDetails", urlPatterns = {"/CustomerDetails"})
public class CustomerDetails extends HttpServlet {

//Выражаем зависимость
    @PersistenceContext(unitName = "TopLink")
    private EntityManager em;
//Указываем ресурс
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  //обрабатываем и геты и посты, приходящие к сервлету.
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustomerDetails</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Поиск информации о клиенте</h1>");
            String customerNr = request.getParameter("customer_nr");
            if ((customerNr != null) && !(customerNr.equals(""))) {
                Customer customer = findByID(new Integer(customerNr));
                if (customer != null) {
                    out.println("<table>");
                    out.println("<tr>");
                    out.println("<td>ID клиента</td>");
                    out.println("<td>" + customerNr + "</td>");
                    out.println("</tr>");
                    out.println("<tr>");
                    out.println("<td>Наименование</td>");
                    out.println("<td>" + customer.getName() + "</td>");
                    out.println("</tr>");
                    out.println("<tr>");
                    out.println("<td>Второй адрес</td>");
                    out.println("<td>" + customer.getAddressline2() + "</td>");
                    out.println("</tr>");
                    out.println("<tr>");
                    out.println("<td>Факс</td>");
                    out.println("<td>" + customer.getFax() + "</td>");
                    out.println("</tr>");
                    out.println("</table>");
                } else {
                    out.println("<em class=\"error\">Клиент не найден.</em>");
                }
            }
            out.println("<form>");
            out.println("ID клиента: <input type='text' name='customer_nr'/>");
            out.println("<input type=submit value=\"Поиск\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

//Получаем данные в сервлете

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

//Отдаём данные в сервлете
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

//Сохраняем данные
    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    public Customer findByID(Integer customerNr) {
        Customer customer = null;
        customer = em.find(Customer.class, customerNr);
        return customer;
    }
}
