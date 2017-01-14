package com.lsl.jsf.i18n;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.lsl.util.JsfUtil;

@ManagedBean(name = "language")
@SessionScoped
public class LanguageBean implements Serializable {

	private String localeCode;
	private static Map<String, Object> countries;

	private static final long serialVersionUID = 1L;

	public Map<String, Object> getCountriesInMap() {
		if (countries == null) {
			countries = new LinkedHashMap<String, Object>();
			ResourceBundle bundle = ResourceBundle.getBundle(JsfUtil.getContextParam("bundle.path.name"), stringToLocale(getLocaleCode()));
			ResourceBundle bundleLangs = ResourceBundle.getBundle(JsfUtil.getContextParam("bundle.languages_available"));
			Enumeration<String> languages = bundleLangs.getKeys();
			while(languages.hasMoreElements()){
				String key = languages.nextElement();
				countries.put(bundle.getString(bundleLangs.getString(key)), key);
			}
		}
		return countries;
	}

	public String getLocaleCode() {
		if(localeCode == null){
			localeCode = FacesContext.getCurrentInstance().getViewRoot().getLocale().toString();
		}
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(stringToLocale(localeCode));
		this.localeCode = localeCode;
		countries.clear();
		countries = null;
	}

	/**
	 * Instantiate a Locale using a string like en_US or pt_BR 
	 * Where: en = language, BR = region
	 * 
	 * @param localeCode
	 * @throws IllegalArgumentException
	 *             if localeCode have length != 5
	 * @return Locale populated
	 */
	public Locale stringToLocale(String localeCode) {
		if (localeCode.length() != 5) {
			throw new IllegalArgumentException("localeCode must be in the format en_US");
		}
		return new Locale(localeCode.substring(0, 2).toLowerCase(), localeCode.substring(3, 5).toUpperCase());
	}

}