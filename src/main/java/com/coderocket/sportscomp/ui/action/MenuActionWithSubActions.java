package com.coderocket.sportscomp.ui.action;


import java.util.List;

public interface MenuActionWithSubActions extends MenuAction{
    List<MenuAction> getSubActions();
}
