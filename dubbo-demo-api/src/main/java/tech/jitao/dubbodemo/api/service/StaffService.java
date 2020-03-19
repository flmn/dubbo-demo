package tech.jitao.dubbodemo.api.service;

import tech.jitao.dubbodemo.api.domain.Staff;
import tech.jitao.dubbodemo.api.dto.AuthenticateResponse;
import tech.jitao.dubbodemo.api.dto.CommonListRequest;
import tech.jitao.dubbodemo.api.exception.MessageException;

import java.util.List;

public interface StaffService {
    List<Staff> listStaffs(CommonListRequest request);

    Staff getStaff(long id);

    Staff createStaff(Staff staff);

    Staff updateStaff(Staff staff);

    AuthenticateResponse authenticate(String username, String password) throws MessageException;
}
