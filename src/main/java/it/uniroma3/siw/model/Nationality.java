package it.uniroma3.siw.model;

public enum Nationality {

	USA("United States"),
	CHN("China"),
	RUS("Russia"),
	GBR("United Kingdom"),
	FRA("France"),
	DEU("Germany"),
	JPN("Japan"),
	ITA("Italy"),
	ESP("Spain"),
	IND("India"),
	BRA("Brazil"),
	KOR("South Korea"),
	CAN("Canada"),
	AUS("Australia"),
	TUR("Turkey"),
	MEX("Mexico"),
	ARG("Argentina"),
	SAU("Saudi Arabia"),
	ZAF("South Africa"),
	IDN("Indonesia"),
	IRN("Iran"),
	ISR("Israel"),
	UKR("Ukraine"),
	PAK("Pakistan"),
	POL("Poland"),
	NLD("Netherlands"),
	SWE("Sweden"),
	CHE("Switzerland"),
	BEL("Belgium"),
	NOR("Norway"),
	AUT("Austria"),
	GRC("Greece"),
	THA("Thailand"),
	PHL("Philippines"),
	VNM("Vietnam"),
	NGA("Nigeria"),
	KEN("Kenya"),
	EGY("Egypt"),
	COL("Colombia"),
	PER("Peru"),
	CHL("Chile"),
	NZL("New Zealand"),
	HUN("Hungary"),
	ROU("Romania"),
	CZE("Czech Republic"),
	PRT("Portugal"),
	FIN("Finland"),
	DNK("Denmark"),
	IRL("Ireland"),
	MAR("Morocco");

	private final String fullName;

	Nationality(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}
}
