package com.codex.cxcarz.admin.register.repository;

import com.codex.cxcarz.admin.register.dto.AdminRegisterDTO;

public interface AdminRegisterRepository {

	AdminRegisterDTO findByEmailId(String emailId) throws Exception;

	AdminRegisterDTO create(AdminRegisterDTO dtoToSave) throws Exception;

}
