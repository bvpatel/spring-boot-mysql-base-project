package me.socialid.contactManagement.audit;

import org.hibernate.envers.RevisionListener;

import java.util.Date;

public class BaseRevisionListener implements RevisionListener {
    @Override
    public void newRevision(Object revisionEntity) {
        BaseRevisionEntity baseRevisionEntity = (BaseRevisionEntity) revisionEntity;
        baseRevisionEntity.setUser("");
        baseRevisionEntity.setModificationDate(new Date());
    }
}
