package by.training.epam.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.training.epam.builders.BeanBuilder;
import by.training.epam.builders.CandiesBuilderFactory;
import by.training.epam.entity.Candy;
import by.training.epam.entity.CandyBean;
import by.training.epam.parsers.XMLParser;
import by.training.epam.utils.FileUtils;
import by.training.epam.utils.XmlValidator;

@WebServlet("/controller.do")
public class MainController extends HttpServlet {

	private static final String CANDIES_VIEW_JSP = "/jsp/candies.jsp";
	private static final String VALIDATION_FALSE_JSP = "/jsp/validationFalse.jsp";
	private static final String CANDIES_LIST_ATTRIBUTE = "candiesList";
	private static final int STEP = 2;
	private static final String SCHEMA_NAME = "schemaName";
	private static final String FILE_NAME = "fileName";
	private static final String PARSER_TYPE = "DOM";

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		req.setCharacterEncoding("utf-8");

		if (req.getSession().getAttribute(CANDIES_LIST_ATTRIBUTE) == null) {

			XmlValidator validator = new XmlValidator();
			FileUtils utils = new FileUtils();
			String fileName = utils.getPropertyValue(FILE_NAME);
			String schemaName = utils.getPropertyValue(SCHEMA_NAME);
			boolean flag = validator.validate(fileName, schemaName);

			if (flag) {
				CandiesBuilderFactory builderFactory = new CandiesBuilderFactory();
				XMLParser parser = builderFactory.createCandiesListBuilder(PARSER_TYPE);
				List<Candy> list = parser.createCandiesList(fileName);
				List<CandyBean> beanList = BeanBuilder.buildCandyBeanList(list);
				req.getSession().setAttribute(CANDIES_LIST_ATTRIBUTE, beanList);
				req.getSession().setAttribute("begin", 0);
				req.getSession().setAttribute("end", STEP);
				getServletContext().getRequestDispatcher(CANDIES_VIEW_JSP).forward(req, resp);
			} else {
				getServletContext().getRequestDispatcher(VALIDATION_FALSE_JSP).forward(req, resp);
			}
			
		} else {

			int begin;
			int end = (int) req.getSession().getAttribute("end");
			@SuppressWarnings("unchecked")
			List<CandyBean> listOfBeans = (List<CandyBean>) req.getSession().getAttribute(CANDIES_LIST_ATTRIBUTE);
			if (req.getParameter("direction") != null && req.getParameter("direction").equals("next")) {
				if ((end + STEP) < listOfBeans.size()) {
					end += STEP;
					begin = end - STEP;
				} else {
					end = listOfBeans.size() - 1;
					begin = end - STEP;
				}
			} else {
				if ((end - STEP) <= STEP) {
					end = STEP;
					begin = 0;
				} else {
					end -= STEP;
					begin = end - STEP;
				}
			}
			req.getSession().setAttribute("begin", begin);
			req.getSession().setAttribute("end", end);
			getServletContext().getRequestDispatcher(CANDIES_VIEW_JSP).forward(req, resp);

		}

	}

}
