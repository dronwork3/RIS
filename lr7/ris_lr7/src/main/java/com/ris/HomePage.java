package com.ris;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

/**
 * Домашняя страница
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	// TODO Добавьте сюда любые свойства страницы или переменные

    /**
	 * Конструктор, который вызывается, когда страница вызывается без сеанса.
	 *
	 * @param parameters
	 *            Page parameters
	 */
    public HomePage(final PageParameters parameters) {

        // Add the simplest type of label
        add(new Label("message", "If you see this message wicket is properly configured and running"));

        // TODO Add your page's components here
    }
}
