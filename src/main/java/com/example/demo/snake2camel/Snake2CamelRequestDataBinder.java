package com.example.demo.snake2camel;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import javax.servlet.ServletRequest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Snake2CamelRequestDataBinder extends ExtendedServletRequestDataBinder {

    public Snake2CamelRequestDataBinder(Object target, String objectName) {
        super(target, objectName);
    }

    protected void addBindValues(MutablePropertyValues mpvs, ServletRequest request) {
        super.addBindValues(mpvs, request);

        // 响应信息 (camel --> snake)
        Class<?> targetClass = getTarget().getClass();
        Field[] fields = targetClass.getDeclaredFields();
        for (Field field : fields) {
            JsonProperty jsonPropertyAnnotation = field.getAnnotation(JsonProperty.class);
            if (jsonPropertyAnnotation != null && mpvs.contains(jsonPropertyAnnotation.value())) {
                if (!mpvs.contains(field.getName())) {
                    mpvs.add(field.getName(), mpvs.getPropertyValue(jsonPropertyAnnotation.value()).getValue());
                }
            }
        }

        // 请求信息 (snake --> camel)
        List<PropertyValue> covertValues = new ArrayList<PropertyValue>();
        for (PropertyValue propertyValue : mpvs.getPropertyValueList()) {
            if(propertyValue.getName().contains("_")) {
                String camelName = Snake2CamelRequestParameterUtil.convertSnakeToCamel(propertyValue.getName());
                if (!mpvs.contains(camelName)) {
                    covertValues.add(new PropertyValue(camelName, propertyValue.getValue()));
                }
            }
        }
        mpvs.getPropertyValueList().addAll(covertValues);
    }
}
