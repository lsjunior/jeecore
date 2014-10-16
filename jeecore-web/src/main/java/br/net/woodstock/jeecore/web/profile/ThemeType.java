package br.net.woodstock.jeecore.web.profile;

public enum ThemeType {

	/**
	 * @formatter:off
	 */
	
	AFTERDARK("afterdark"),
	AFTERNOON("afternoon"),
	AFTERWORK("afterwork"),
	ARISTO("aristo"),
	BLACK_TIE("black-tie"),
	BLITZER("blitzer"),
	BLUESKY("bluesky"),
	BOOTSTRAP("bootstrap"),
	CASABLANCA("casablanca"),
	CRUZE("cruze"),
	CUPERTINO("cupertino"),
	DARK_HIVE("dark-hive"),
	DELTA("delta"),
	DOT_LUV("dot-luv"),
	EGGPLANT("eggplant"),
	EXCITE_BIKE("excite-bike"),
	FLICK("flick"),
	GLASS_X("glass-x"),
	HOME("home"),
	HOT_SNEAKS("hot-sneaks"),
	HUMANITY("humanity"),
	LE_FROG("le-frog"),
	MIDNIGHT("midnight"),
	MINT_CHOC("mint-choc"),
	OVERCAST("overcast"),
	PEPPER_GRINDER("pepper-grinder"),
	REDMOND("redmond"),
	ROCKET("rocket"),
	SAM("sam"),
	SMOOTHNESS("smoothness"),
	SOUTH_STREET("south-street"),
	START("start"),
	SUNNY("sunny"),
	SWANKY_PURSE("swanky-purse"),
	TRONTASTIC("trontastic"),
	UI_DARKNESS("ui-darkness"),
	UI_LIGHTNESS("ui-lightness"),
	VADER("vader");
	
	/**
	 * @formatter:on
	 */

	private String	type;

	private ThemeType(final String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public static ThemeType typeOf(final String type) {
		for (ThemeType t : ThemeType.values()) {
			if (t.getType().equals(type)) {
				return t;
			}
		}
		return null;
	}

}
