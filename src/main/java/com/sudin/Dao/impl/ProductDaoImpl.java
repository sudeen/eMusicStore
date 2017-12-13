package com.sudin.Dao.impl;

import com.sudin.Dao.ProductDao;
import com.sudin.Model.Product;
import org.hibernate.*;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;
    Session session;
    Transaction transaction;

    public void addProduct(Product product) {
//        try {
//            session=sessionFactory.openSession();
//            transaction = session.beginTransaction();
//            session.save(product);
//            transaction.commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
        try {
            sessionFactory.getCurrentSession().save(product);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getProductById(int id) {
        Product product = null;
        try {
            session=sessionFactory.openSession();
//            session = sessionFactory.getCurrentSession();
            String sql="SELECT * FROM Product p WHERE p.productId= :productId";
            SQLQuery query=session.createSQLQuery(sql);
            query.setParameter("productId",id);
//            query.addScalar("ProductId", IntegerType.INSTANCE);
            query.addScalar("ProductCategory", StringType.INSTANCE);
            query.addScalar("ProductCondition", StringType.INSTANCE);
            query.addScalar("ProductDescription", StringType.INSTANCE);
            query.addScalar("ProductManufacturer", StringType.INSTANCE);
            query.addScalar("ProductName", StringType.INSTANCE);
            query.addScalar("ProductPrice", DoubleType.INSTANCE);
            query.addScalar("ProductStatus", StringType.INSTANCE);
            query.addScalar("UnitStock", IntegerType.INSTANCE);
//            product = (Product) session.get(Product.class, id);
            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public List<Product> getAllProduct() {
        List<Product> productList= null;
        try {
            session=sessionFactory.openSession();
            String sql="SELECT * FROM PRODUCT";
            SQLQuery query=session.createSQLQuery(sql);
//            Query query=session.createQuery("FROM Product");
//            System.out.println("query output " +new Gson().toJson( query.list()));
            query.addScalar("ProductId", IntegerType.INSTANCE);
            query.addScalar("ProductCategory", StringType.INSTANCE);
            query.addScalar("ProductCondition", StringType.INSTANCE);
            query.addScalar("ProductDescription", StringType.INSTANCE);
            query.addScalar("ProductManufacturer", StringType.INSTANCE);
            query.addScalar("ProductName", StringType.INSTANCE);
            query.addScalar("ProductPrice", DoubleType.INSTANCE);
            query.addScalar("ProductStatus", StringType.INSTANCE);
            query.addScalar("UnitStock", IntegerType.INSTANCE);
            productList = query.list();
            return productList;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
        //session.flush();
   }

    public void deleteProduct(int id) {
//        Session session=sessionFactory.getCurrentSession();
//        session.delete(getProductById(id));
//        session.flush();
        Product product = (Product) sessionFactory.getCurrentSession().load(
                Product.class, id);
        if (null != product) {
            this.sessionFactory.getCurrentSession().delete(product);
        }
    }
}
