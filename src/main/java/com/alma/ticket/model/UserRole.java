package com.alma.ticket.model;

/*
* Роль пользователя в системе
* */
public enum UserRole {
    ADMIN,// администратор
    MANAGER,// менеджер
    AUTHORIZED_USER,// автоизованный пользователь
    UNAUTHORIZED_USER,// неакторизованный пользователь
    DRIVER // водитель
}
