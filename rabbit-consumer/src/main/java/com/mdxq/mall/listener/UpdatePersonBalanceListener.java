package com.mdxq.mall.listener;

import com.mdxq.mall.entity.Person;
import com.mdxq.mall.mapper.PersonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "upbm_queue")
@Slf4j
public class UpdatePersonBalanceListener {
    @Autowired
    private PersonMapper personMapper;

    @RabbitHandler
    public void handle(Person person) {
        personMapper.updateBalance(person.getAccountBalance(), person.getId(), person.getVersion());
    }
}
