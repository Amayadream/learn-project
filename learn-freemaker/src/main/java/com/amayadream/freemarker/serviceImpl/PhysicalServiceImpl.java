package com.amayadream.freemarker.serviceImpl;

import com.amayadream.freemarker.dao.IPhysicalDao;
import com.amayadream.freemarker.model.PhysicalColumn;
import com.amayadream.freemarker.model.PhysicalForeign;
import com.amayadream.freemarker.model.PhysicalPrimary;
import com.amayadream.freemarker.model.PhysicalTable;
import com.amayadream.freemarker.service.IPhysicalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.04.13 17:02
 */
@Service(value = "physicalService")
public class PhysicalServiceImpl implements IPhysicalService {

    @Resource
    private IPhysicalDao physicalDao;

    @Override
    public List<PhysicalTable> showTables() {
        return physicalDao.showTables();
    }

    @Override
    public List<PhysicalColumn> showColumns(String tableName) {
        return physicalDao.showColumns(tableName);
    }

    @Override
    public List<PhysicalPrimary> showPrimarys(String tableName) {
        return physicalDao.showPrimarys(tableName);
    }

    @Override
    public List<PhysicalForeign> showForeigns(String tableName) {
        return physicalDao.showForeigns(tableName);
    }
}
