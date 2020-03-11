package tech.jitao.dubbodemo.service.service;

import org.apache.dubbo.config.annotation.Service;
import tech.jitao.dubbodemo.api.domain.Staff;
import tech.jitao.dubbodemo.api.dto.CommonListRequest;
import tech.jitao.dubbodemo.api.service.StaffService;
import tech.jitao.dubbodemo.service.repository.StaffRepository;

import java.util.List;

@Service(version = "1.0.0")
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public List<Staff> listStaffs(CommonListRequest request) {
        return null;
    }

    @Override
    public Staff getStaff(long id) {
        return null;
    }

    @Override
    public Staff createStaff(Staff staff) {
        return null;
    }

    @Override
    public Staff updateStaff(Staff staff) {
        return null;
    }
}
