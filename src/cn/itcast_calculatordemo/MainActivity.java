package cn.itcast_calculatordemo;

/**
 * @author Kelvin
 * @version v1.0
 * 
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnClickListener {

	// 定义各类按钮
	private Button btn_0;// 数字0按钮
	private Button btn_1;// 数字1按钮
	private Button btn_2;// 数字2按钮
	private Button btn_3;// 数字3按钮
	private Button btn_4;// 数字4按钮
	private Button btn_5;// 数字5按钮
	private Button btn_6;// 数字6按钮
	private Button btn_7;// 数字7按钮
	private Button btn_8;// 数字8按钮
	private Button btn_9;// 数字9按钮
	private Button btn_plus;// 加号按钮
	private Button btn_minus;// 减号按钮
	private Button btn_multiply;// 乘号按钮
	private Button btn_divide;// 除号按钮
	private Button btn_point;// 小数点按钮
	private Button btn_clear;// 清除按钮
	private Button btn_del;// 删除按钮
	private Button btn_equal;// 等于号按钮

	private ToggleButton togButton;// 趣味功能的按钮

	// 定义显示区域
	EditText et_input;// 显示屏
	EditText et_warning;// 操作提示屏

	boolean clear_flag;// 清空标识符
	boolean interst_flag;// 趣味标识符

	private String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 对各种按钮实例化
		btn_0 = (Button) findViewById(R.id.btn_0);
		btn_1 = (Button) findViewById(R.id.btn_1);
		btn_2 = (Button) findViewById(R.id.btn_2);
		btn_3 = (Button) findViewById(R.id.btn_3);
		btn_4 = (Button) findViewById(R.id.btn_4);
		btn_5 = (Button) findViewById(R.id.btn_5);
		btn_6 = (Button) findViewById(R.id.btn_6);
		btn_7 = (Button) findViewById(R.id.btn_7);
		btn_8 = (Button) findViewById(R.id.btn_8);
		btn_9 = (Button) findViewById(R.id.btn_9);
		btn_plus = (Button) findViewById(R.id.btn_plus);
		btn_minus = (Button) findViewById(R.id.btn_minus);
		btn_multiply = (Button) findViewById(R.id.btn_multiply);
		btn_divide = (Button) findViewById(R.id.btn_divide);
		btn_point = (Button) findViewById(R.id.btn_point);
		btn_equal = (Button) findViewById(R.id.btn_equal);
		btn_clear = (Button) findViewById(R.id.btn_clear);
		btn_del = (Button) findViewById(R.id.btn_del);

		togButton = (ToggleButton) findViewById(R.id.tog_btn1);// 对趣味功能的按钮进行实例化

		et_input = (EditText) findViewById(R.id.et_input);// 对显示屏进行实例化
		et_warning = (EditText) findViewById(R.id.et_warning);// 对提示屏进行实例化

		// 对各种按钮设置点击监听事件
		btn_0.setOnClickListener(this);
		btn_1.setOnClickListener(this);
		btn_2.setOnClickListener(this);
		btn_3.setOnClickListener(this);
		btn_4.setOnClickListener(this);
		btn_5.setOnClickListener(this);
		btn_6.setOnClickListener(this);
		btn_7.setOnClickListener(this);
		btn_8.setOnClickListener(this);
		btn_9.setOnClickListener(this);
		btn_plus.setOnClickListener(this);// +
		btn_minus.setOnClickListener(this);// -
		btn_multiply.setOnClickListener(this);// *
		btn_divide.setOnClickListener(this);// /
		btn_point.setOnClickListener(this);// .
		btn_equal.setOnClickListener(this);// =
		btn_clear.setOnClickListener(this);
		btn_del.setOnClickListener(this);

		// 对显示屏设置监听事件
		et_input.setOnClickListener(this);// 对显示屏设置监听事件
		et_warning.setOnClickListener(this);// 对提示屏设置监听事件

		// 对趣味按钮设置监听事件
		togButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub

				interst_flag = (isChecked ? true : false);

			}
		});

	}

	//监听事件响应
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// 取显示屏的内容
		String str = et_input.getText().toString();
		switch (v.getId()) {

		// 数字键
		case R.id.btn_0:
		case R.id.btn_1:
		case R.id.btn_2:
		case R.id.btn_3:
		case R.id.btn_4:
		case R.id.btn_5:
		case R.id.btn_6:
		case R.id.btn_7:
		case R.id.btn_8:
		case R.id.btn_9:
		case R.id.btn_point:

			MyLogUtil.d(TAG, "clear_flag is " + clear_flag);
			// 清屏
			if (clear_flag) {
				clear_flag = false;
				str = ""; // 清显示屏
			}

			et_input.setText(str + ((Button) v).getText());			
			break;

		// 运算法则
		case R.id.btn_plus:
		case R.id.btn_multiply:
		case R.id.btn_divide:

			// 判断第一个操作数若为空，则乘号、除号、加号运算符不需要响应，只有减号需要响应
			if (str.equals("")) {
				break;
			}

		case R.id.btn_minus:   //减号运算符
			// 清屏
			if (clear_flag) {
				clear_flag = false;
				str = ""; // 清显示屏
			}

			et_input.setText(str + " " + ((Button) v).getText() + " ");
			break;

		// 清除键
		case R.id.btn_clear:
			et_input.setText("");
			et_warning.setText("");
			break;

		// 删除键
		case R.id.btn_del:
			MyLogUtil.d(TAG, "删除键");
			MyLogUtil.d(TAG, "str is " + str);

			if (str.length() > 0) {
				MyLogUtil.d(TAG, "str.length() = " + str.length());
				MyLogUtil.d(TAG, "str is " + str);
				et_input.setText(str.substring(0, str.length() - 1));
				break;
			} else {
				MyLogUtil.d(TAG, "里面没东西了");
				MyLogUtil.d(TAG, "str is " + str);

				// 清屏
				if (clear_flag) {
					clear_flag = false;
					et_warning.setText(""); // 清提示屏
				}

				break;
			}

			// 等于键
		case R.id.btn_equal:
			getResult();// 计算结果
			break;

		}
	}

	
	/**
	 * 计算运算结果
	 */
	private void getResult() {

		String exp = et_input.getText().toString();
		int r = 0;

		// 判断是否为两位数运算
		int count = 0;
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			MyLogUtil.d(TAG, "各个字符为：" + c);
			if (c == ' ') {
				count++;
			}
		}

		if (count <= 2) {
			// 是两个数之内的运算

			// 如果直接按等号时进入该判断语句中，并最终返回方法调用处
			if (exp.equals(null) || exp.equals("")) {
				MyLogUtil.d(TAG, "直接按的等号键");
				et_input.setText("");
				return;
			}

			MyLogUtil.d(TAG, "exp = " + exp);

			// 修改清空标识符
			clear_flag = true;

			String s1 = "";
			String s2 = "";
			String op = "";

			/**************************************************************************/

			// 判断是否含运算符
			if (exp.contains(" ")) {
				// 含有运算符，即一定有第一个操作数，是否有第二个操作数有待判断
				s1 = exp.substring(0, exp.indexOf(" "));// 运算符前的数字
				MyLogUtil.d(TAG, "操作数s1 = " + s1 + "是");
				op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);// 运算符
				MyLogUtil.d(TAG, "运算符op = " + op + "是");
				s2 = exp.substring(exp.indexOf(" ") + 3);// 运算符后面的数字
				MyLogUtil.d(TAG, "操作数s2 = " + s2 + "是");

				double result = 0.0;

				if (!s1.equals("") && !s2.equals("")) { // s1 和 时 s2 均不为空
					MyLogUtil.d(TAG, "s1 不为空，s2 不为空 ");
					double d1 = Double.parseDouble(s1);
					double d2 = Double.parseDouble(s2);

					if (op.equals("+")) {
						result = d1 + d2;
					} else if (op.equals("-")) {
						result = d1 - d2;
					} else if (op.equals("×")) {
						result = d1 * d2;

					} else if (op.equals("/")) {
						if (d2 == 0) {

							MyLogUtil.d(TAG, "除数为0");
							et_warning.setText("除数不能为零！");
							return;

						} else {
							result = d1 / d2;
							MyLogUtil.d(TAG, "除数为:" + s2);
							MyLogUtil.d(TAG, "result:" + result);
						}
					}

					// 判断是否是小数计算
					if (!s1.contains(".") && !s2.contains(".")) {
						// 当s1和s2均为int型时，还要判断结果是否为小数
						double d = result - (int) result;
						MyLogUtil.d(TAG, "(int)result = " + (int) result);
						String isEqual = String.valueOf(d);
						MyLogUtil.d(TAG, "isEqual = " + isEqual);
						if (isEqual.equals("0.0") || isEqual.equals("0")) {
							// 此时表明计算结果为int类型
							r = (int) result;
							MyLogUtil.d(TAG, "r = " + r);
							et_input.setText(r + "");
						} else {
							// 否则就是处理像1/3这种情况，其结果应该显示为double类型
							et_input.setText(result + "");
						}

					} else {
						et_input.setText(result + "");
					}
				} else if (!s1.equals("") && s2.equals("")) { // s1 不为空，s2 为空

					MyLogUtil.d(TAG, "只有第一个操作数，exp = " + exp);
					MyLogUtil.d(TAG, "只有第一个操作数");
					MyLogUtil.d(TAG, "s1 = " + s1 + "是");

					String s11 = exp.substring(0, exp.indexOf(" "));// 运算符前的数字
					double d11 = Double.parseDouble(s11);
					result = d11;

					MyLogUtil.d(TAG, "s1 不为空，s2 为空 ");
					// 判断是否是小数计算
					if (!s11.contains(".")) {
						r = (int) result;
						et_input.setText(r + "");
						// et_input.setText(r);
					} else {
						et_input.setText(result + "");
					}

				} else if (s1.equals("") && !s2.equals("")) { // s1 为空，s2不 为空
					MyLogUtil.d(TAG, "s1 为空，s2 不为空 ");
					if (op.equals("-")) {
						double d2 = Double.parseDouble(s2);

						// 判断是否是小数计算
						if (!s2.contains(".")) {
							// 不为小数
							r = -(int) d2;
							et_input.setText(r + "");
						} else {
							// 是小数
							et_input.setText(-d2 + "");

						}

					} else if (op.equals("+")) {
						double d2 = Double.parseDouble(s2);
						// 判断是否是小数计算
						if (!s2.contains(".")) {
							// 不为小数
							r = (int) d2;
							et_input.setText(r + "");
						} else {
							// 是小数
							et_input.setText(d2 + "");
						}
					} else if (op.equals("/") || op.equals("*")) {
						et_input.setText(exp);
					}

				} else if (s1.equals("") && s2.equals("")) { // s1 为空，s2为空
					MyLogUtil.d(TAG, "s1 为空，s2 为空 ");
					et_input.setText(exp);
				}

			} else {
				// 不带操作符，即只有第一个操作数时
				MyLogUtil.d(TAG, "不带操作符，即只有第一个操作数时 ");

				double result;

				s1 = exp;
				double d1 = Double.parseDouble(s1);
				// 判断是否是小数计算
				if (!s1.contains(".")) {
					// 不是小数计算
					MyLogUtil.d(TAG, "不带操作符，即只有第一个操作数时 ,且不为小数");
					r = (int) d1;
					et_input.setText(r + "");
				} else {
					// 是小数计算
					MyLogUtil.d(TAG, "不带操作符，即只有第一个操作数时 ,且为小数");
					result = d1;
					et_input.setText(result + "");
				}

			}

			/***********************************************************************************/

			et_warning.setText(s1 + op + s2 + "=");
		} else {
			// 不是两个数的运算
			et_warning.setText("对不起，暂只支持两个数的运算.");
			clear_flag = true;

		}

		// 当趣味标识符为true时，才进入趣味模式
		if (interst_flag) {
			if (r == 520) {
				et_warning.setText("我爱你!   ");
			} else if (r == 1314) {
				et_warning.setText("一生一世...   ");
			} else if (r == 1314521) {
				et_warning.setText("一生一世,我爱你！^_^   ");
			} else if (r == 250) {
				et_warning.setText("你是250吗？ @^…^@   ");
			} else {
				et_warning.setText("傻眼了吧…T_T, 算不出来了吧, 哈哈…  ");
			}
		}

	}
}
