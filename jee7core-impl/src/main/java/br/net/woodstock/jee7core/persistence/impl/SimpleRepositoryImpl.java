package br.net.woodstock.jee7core.persistence.impl;

import java.io.Serializable;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;

import br.net.woodstock.jee7core.persistence.SimpleRepository;
import br.net.woodstock.jee7core.util.Version;
import br.net.woodstock.rockframework.domain.Entity;
import br.net.woodstock.rockframework.domain.persistence.orm.ORMFilter;
import br.net.woodstock.rockframework.domain.persistence.orm.ORMResult;
import br.net.woodstock.rockframework.domain.persistence.orm.impl.AbstractJPARepository;

@SuppressWarnings("rawtypes")
public class SimpleRepositoryImpl extends AbstractJPARepository implements SimpleRepository {

	private static final long	serialVersionUID	= -Version.VERSION;

	private EntityManager		entityManager;

	public SimpleRepositoryImpl() {
		super();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(final Entity e) {
		super.save(e);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(final Entity e) {
		super.update(e);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(final Entity e) {
		super.delete(e);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public <E extends Entity<T>, T extends Serializable> E get(final Class<E> clazz, final T id) {
		return super.get(clazz, id);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public <E> E getSingle(final ORMFilter filter) {
		return super.getSingle(filter);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public ORMResult getCollection(final ORMFilter filter) {
		return super.getCollection(filter);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void executeUpdate(final ORMFilter filter) {
		super.executeUpdate(filter);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

}
