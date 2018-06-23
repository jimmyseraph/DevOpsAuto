#Author: liudao@testops.vip
@tag
Feature: Register功能
  ECshop网站的用户注册功能

  Scenario: 新用户注册成功
    Given 打开ECshop首页
    And 点击免费注册链接
    When 填入"用户名"为"liudao016"
    And 填入"邮箱"为"liudao016@163.com"
    And 填入"密码"为"123456"
    And 填入"确认密码"为"123456"
    And 填入"手机号码"为"13455566644"
    And 点击注册按钮
    Then 在用户页面显示"用户名 liudao016 注册成功"

  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
