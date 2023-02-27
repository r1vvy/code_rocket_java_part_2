package com.coderocket.sportscomp.in.action;


import java.util.List;

public interface MenuActionWithSubActions extends MenuAction{
    List<MenuAction> getSubActions();
}
