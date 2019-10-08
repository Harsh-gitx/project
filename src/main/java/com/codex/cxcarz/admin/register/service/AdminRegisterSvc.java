package com.codex.cxcarz.admin.register.service;

import com.codex.cxcarz.admin.register.dto.AdminRegisterDTO;

public interface AdminRegisterSvc {

	AdminRegisterDTO preSave(AdminRegisterDTO dtoToSave) throws  Exception;
	AdminRegisterDTO create(AdminRegisterDTO dtoToSave) throws Exception;

}
