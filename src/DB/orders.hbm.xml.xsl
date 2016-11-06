<hibernate-mapping>
    <class name="ConnectToDB.Order" table="orders">
        <id name="order_id" type="int" column="order_id">
            <generator class="increment"/>
        </id>
        <property name="user" column="user" type="string"/>
        <property name="instrument_id" column="instrument_id" type="int"/>
        <property name="amount" column="amount" type="int"/>
        <property name="curDate" column="date" type="date"/>
        <property name="shop" column="shop" type="string"/>
        <property name="courier" column="courier" type="string"/>
    </class>
</hibernate-mapping>