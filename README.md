# PopupLayout

[![License](https://img.shields.io/badge/License%20-Apache%202-337ab7.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![](https://jitpack.io/v/CodingEnding/PopupLayout.svg)](https://jitpack.io/#CodingEnding/PopupLayout)
[![MinSdk](https://img.shields.io/badge/MinSDK-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)

PopupLayout是通用弹出布局辅助库，允许开发者从顶部、底部、左侧、右侧和中心这五个位置弹出自己指定的View，此外还提供圆角和动画特性。

## 效果预览

![](https://i.imgur.com/RPNMvX6.jpg)

![image](https://github.com/CodingEnding/PopupLayout/blob/master/ScreenShot/popupLayout_demo.gif)

## Gradle

[![](https://jitpack.io/v/CodingEnding/PopupLayout.svg)](https://jitpack.io/#CodingEnding/PopupLayout)

```
//根项目下的build.gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}

//主项目下的build.gradle
dependencies {
    implementation 'com.github.CodingEnding:PopupLayout:v1.0'
}
```

## Usage

### 基本使用

PopLayout的使用非常简单，只需要执行以下两步：

**1.初始化PopupLayout**

通过调用静态方法init初始化PopupLayout。这个方法有两个参数：第一个参数是Context对象，第二个参数代表弹出布局的内容，可以将layout资源Id或者View对象作为参数传入，如下所示：

```
//1.使用layout资源Id作为弹出布局的内容
PopupLayout popupLayout=PopupLayout.init(MainActivity.this, R.layout.layout_left);

//2.使用View作为弹出布局的内容
View view=View.inflate(MainActivity.this,R.layout.layout_bottom_menu,null);
PopupLayout popupLayout=PopupLayout.init(MainActivity.this,view);

```

**2.在指定位置显示弹出布局**

PopupLayout可以从屏幕顶部、底部、左侧、右侧和中心弹出（默认从底部弹出），如下所示：

```
//从左侧弹出
popupLayout.show(PopupLayout.POSITION_LEFT);
//默认从底部弹出
popupLayout.show();
```

position的可选值：
- POSITION_LEFT
- POSITION_RIGHT
- POSITION_CENTER
- POSITION_TOP
- POSITION_BOTTOM

### 关闭弹出布局

点击弹出布局之外的区域，PopupLayout会被自动关闭。当然，也可以通过调用dismiss或hide方法手动关闭。这两个方法的区别在于hide只是隐藏弹出布局，并不会释放资源；而dismiss会销毁弹出布局并释放资源。通常情况下，建议使用dismiss方法。

```
public void dismiss()
public void hide()
```

**注意**：在Activity退出时必须使用dismiss方法销毁弹出布局，释放资源。

### 限制弹出布局的大小

默认情况下，PopupLayout会根据不同的弹出位置自动适配弹出布局的大小。具体而言，如果从顶部/底部弹出，宽度为MATCH_PARENT，高度为WRAP_CONTENT；如果从左侧/右侧弹出，宽度为WRAP_CONTENT，高度为MATCH_PARENT；如果从中心弹出，宽度为WRAP_CONTENT，高度为WRAP_CONTENT。

当然，PopupLayout也提供了setHeight和setWidth两个方法用于手动设置弹出布局的大小。这两个方法原型如下：

```
/**
 * 设置弹出布局的高度
 * @param height 高度
 * @param dpMode 是否以dp为单位
 */
public void setHeight(int height,boolean dpMode)

/**
 * 设置弹出布局的宽度
 * @param width 宽度
 * @param dpMode 是否以dp为单位
 */
public void setWidth(int width,boolean dpMode)
```

**注意**：这两个方法必须要在调用show方法之前使用才有效。

### 相关方法

| 方法名  | 返回值| 说明 |
| :---------|:-----|:-----|
| static init(Context context,@LayoutRes int contentLayoutId) | PopupLayout | 初始化弹出布局 |
| static init(Context context,View contentView) | PopupLayout | 初始化弹出布局 |
| show(int position) | void | 从指定位置显示弹出布局 |
| show()| void | 默认从底部显示弹出布局 |
| dismiss() | void | 隐藏弹出布局（同时会销毁弹出布局，释放资源），建议使用 |
| hide() | void | 隐藏弹出布局（不会销毁弹出布局），不会触发DismissListener |
| setUseRadius(boolean useRadius) | void | 是否使用圆角特性（默认使用） |
| setHeight(int height,boolean dpMode) | void | 设置弹出布局的高度 |
| setWidth(int width,boolean dpMode) | void | 设置弹出布局的宽度 |
| setDismissListener(DismissListener dismissListener) | void | 设置Dismiss监听器（在弹出布局消失时触发） |


### 监听器

PopupLayout允许使用者监听弹出布局的消失事件，只需要为PopupLayout设置DismissListener即可，如下所示：

```
PopupLayout popupLayout=PopupLayout.init(MainActivity.this, R.layout.layout_bottom);
popupLayout.setDismissListener(new PopupLayout.DismissListener() {
    @Override
    public void onDismiss() {
        Toast.makeText(MainActivity.this,"弹出窗口关闭",Toast.LENGTH_SHORT).show();
    }
});//添加监听器
```

## Blog

欢迎访问我的博客：

> [https://blog.csdn.net/codingending](https://blog.csdn.net/codingending)

## License


    Copyright CodingEnding

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
