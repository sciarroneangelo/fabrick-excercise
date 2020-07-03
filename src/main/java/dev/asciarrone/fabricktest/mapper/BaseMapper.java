package dev.asciarrone.fabricktest.mapper;

import java.text.SimpleDateFormat;

public class BaseMapper {
	SimpleDateFormat viewDateFormat = new SimpleDateFormat("dd/mm/yyyy");
	SimpleDateFormat apiDateFormat = new SimpleDateFormat("yyyy-mm-dd");
}
