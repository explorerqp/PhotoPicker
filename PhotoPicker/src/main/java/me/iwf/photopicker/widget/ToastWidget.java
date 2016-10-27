package me.iwf.photopicker.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import me.iwf.photopicker.R;

/**
 * Toast提示信息，取消多次重复显示
 * 
 * @author Rock Lee
 * @date 2015年9月14日
 */
public class ToastWidget {
	private static Toast toast;
	private static TextView text;

	/**
	 * 
	 * @param context
	 *            上下文
	 * @param toastStr
	 *            提示信息
	 */
	public static void show(Context context, String toastStr) {
		if (context == null) {
			return;
		}
		Activity activity = (Activity) context;
		if (toast == null) {
			View layout = LayoutInflater.from(context).inflate(
					R.layout.__picker_toast_defult,
					(ViewGroup) activity.findViewById(R.id.toast_layout_root));
			text = (TextView) layout.findViewById(R.id.text);
			toast = new Toast(context);
//			toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);  
			toast.setView(layout);

		}
		toastStr = !isEmpty(toastStr) ? toastStr : "抱歉，请稍后重新尝试操作.";
		
		if(toastStr.trim().length() > 20) {
			toast.setDuration(Toast.LENGTH_LONG);
		} else {
			toast.setDuration(Toast.LENGTH_SHORT);
		}
		
		text.setText(toastStr);
		toast.show();
	}

	/**
	 * 判断给定字符串是否空白串 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
	 */
	private static boolean isEmpty(CharSequence input) {
		if (input == null || "".equals(input))
			return true;

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
				return false;
			}
		}
		return true;
	}
}
