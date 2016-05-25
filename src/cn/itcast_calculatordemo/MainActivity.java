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

	// ������ఴť
	private Button btn_0;// ����0��ť
	private Button btn_1;// ����1��ť
	private Button btn_2;// ����2��ť
	private Button btn_3;// ����3��ť
	private Button btn_4;// ����4��ť
	private Button btn_5;// ����5��ť
	private Button btn_6;// ����6��ť
	private Button btn_7;// ����7��ť
	private Button btn_8;// ����8��ť
	private Button btn_9;// ����9��ť
	private Button btn_plus;// �ӺŰ�ť
	private Button btn_minus;// ���Ű�ť
	private Button btn_multiply;// �˺Ű�ť
	private Button btn_divide;// ���Ű�ť
	private Button btn_point;// С���㰴ť
	private Button btn_clear;// �����ť
	private Button btn_del;// ɾ����ť
	private Button btn_equal;// ���ںŰ�ť

	private ToggleButton togButton;// Ȥζ���ܵİ�ť

	// ������ʾ����
	EditText et_input;// ��ʾ��
	EditText et_warning;// ������ʾ��

	boolean clear_flag;// ��ձ�ʶ��
	boolean interst_flag;// Ȥζ��ʶ��

	private String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// �Ը��ְ�ťʵ����
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

		togButton = (ToggleButton) findViewById(R.id.tog_btn1);// ��Ȥζ���ܵİ�ť����ʵ����

		et_input = (EditText) findViewById(R.id.et_input);// ����ʾ������ʵ����
		et_warning = (EditText) findViewById(R.id.et_warning);// ����ʾ������ʵ����

		// �Ը��ְ�ť���õ�������¼�
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

		// ����ʾ�����ü����¼�
		et_input.setOnClickListener(this);// ����ʾ�����ü����¼�
		et_warning.setOnClickListener(this);// ����ʾ�����ü����¼�

		// ��Ȥζ��ť���ü����¼�
		togButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub

				interst_flag = (isChecked ? true : false);

			}
		});

	}

	//�����¼���Ӧ
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// ȡ��ʾ��������
		String str = et_input.getText().toString();
		switch (v.getId()) {

		// ���ּ�
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
			// ����
			if (clear_flag) {
				clear_flag = false;
				str = ""; // ����ʾ��
			}

			et_input.setText(str + ((Button) v).getText());			
			break;

		// ���㷨��
		case R.id.btn_plus:
		case R.id.btn_multiply:
		case R.id.btn_divide:

			// �жϵ�һ����������Ϊ�գ���˺š����š��Ӻ����������Ҫ��Ӧ��ֻ�м�����Ҫ��Ӧ
			if (str.equals("")) {
				break;
			}

		case R.id.btn_minus:   //���������
			// ����
			if (clear_flag) {
				clear_flag = false;
				str = ""; // ����ʾ��
			}

			et_input.setText(str + " " + ((Button) v).getText() + " ");
			break;

		// �����
		case R.id.btn_clear:
			et_input.setText("");
			et_warning.setText("");
			break;

		// ɾ����
		case R.id.btn_del:
			MyLogUtil.d(TAG, "ɾ����");
			MyLogUtil.d(TAG, "str is " + str);

			if (str.length() > 0) {
				MyLogUtil.d(TAG, "str.length() = " + str.length());
				MyLogUtil.d(TAG, "str is " + str);
				et_input.setText(str.substring(0, str.length() - 1));
				break;
			} else {
				MyLogUtil.d(TAG, "����û������");
				MyLogUtil.d(TAG, "str is " + str);

				// ����
				if (clear_flag) {
					clear_flag = false;
					et_warning.setText(""); // ����ʾ��
				}

				break;
			}

			// ���ڼ�
		case R.id.btn_equal:
			getResult();// ������
			break;

		}
	}

	
	/**
	 * ����������
	 */
	private void getResult() {

		String exp = et_input.getText().toString();
		int r = 0;

		// �ж��Ƿ�Ϊ��λ������
		int count = 0;
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			MyLogUtil.d(TAG, "�����ַ�Ϊ��" + c);
			if (c == ' ') {
				count++;
			}
		}

		if (count <= 2) {
			// ��������֮�ڵ�����

			// ���ֱ�Ӱ��Ⱥ�ʱ������ж�����У������շ��ط������ô�
			if (exp.equals(null) || exp.equals("")) {
				MyLogUtil.d(TAG, "ֱ�Ӱ��ĵȺż�");
				et_input.setText("");
				return;
			}

			MyLogUtil.d(TAG, "exp = " + exp);

			// �޸���ձ�ʶ��
			clear_flag = true;

			String s1 = "";
			String s2 = "";
			String op = "";

			/**************************************************************************/

			// �ж��Ƿ������
			if (exp.contains(" ")) {
				// �������������һ���е�һ�����������Ƿ��еڶ����������д��ж�
				s1 = exp.substring(0, exp.indexOf(" "));// �����ǰ������
				MyLogUtil.d(TAG, "������s1 = " + s1 + "��");
				op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);// �����
				MyLogUtil.d(TAG, "�����op = " + op + "��");
				s2 = exp.substring(exp.indexOf(" ") + 3);// ��������������
				MyLogUtil.d(TAG, "������s2 = " + s2 + "��");

				double result = 0.0;

				if (!s1.equals("") && !s2.equals("")) { // s1 �� ʱ s2 ����Ϊ��
					MyLogUtil.d(TAG, "s1 ��Ϊ�գ�s2 ��Ϊ�� ");
					double d1 = Double.parseDouble(s1);
					double d2 = Double.parseDouble(s2);

					if (op.equals("+")) {
						result = d1 + d2;
					} else if (op.equals("-")) {
						result = d1 - d2;
					} else if (op.equals("��")) {
						result = d1 * d2;

					} else if (op.equals("/")) {
						if (d2 == 0) {

							MyLogUtil.d(TAG, "����Ϊ0");
							et_warning.setText("��������Ϊ�㣡");
							return;

						} else {
							result = d1 / d2;
							MyLogUtil.d(TAG, "����Ϊ:" + s2);
							MyLogUtil.d(TAG, "result:" + result);
						}
					}

					// �ж��Ƿ���С������
					if (!s1.contains(".") && !s2.contains(".")) {
						// ��s1��s2��Ϊint��ʱ����Ҫ�жϽ���Ƿ�ΪС��
						double d = result - (int) result;
						MyLogUtil.d(TAG, "(int)result = " + (int) result);
						String isEqual = String.valueOf(d);
						MyLogUtil.d(TAG, "isEqual = " + isEqual);
						if (isEqual.equals("0.0") || isEqual.equals("0")) {
							// ��ʱ����������Ϊint����
							r = (int) result;
							MyLogUtil.d(TAG, "r = " + r);
							et_input.setText(r + "");
						} else {
							// ������Ǵ�����1/3�������������Ӧ����ʾΪdouble����
							et_input.setText(result + "");
						}

					} else {
						et_input.setText(result + "");
					}
				} else if (!s1.equals("") && s2.equals("")) { // s1 ��Ϊ�գ�s2 Ϊ��

					MyLogUtil.d(TAG, "ֻ�е�һ����������exp = " + exp);
					MyLogUtil.d(TAG, "ֻ�е�һ��������");
					MyLogUtil.d(TAG, "s1 = " + s1 + "��");

					String s11 = exp.substring(0, exp.indexOf(" "));// �����ǰ������
					double d11 = Double.parseDouble(s11);
					result = d11;

					MyLogUtil.d(TAG, "s1 ��Ϊ�գ�s2 Ϊ�� ");
					// �ж��Ƿ���С������
					if (!s11.contains(".")) {
						r = (int) result;
						et_input.setText(r + "");
						// et_input.setText(r);
					} else {
						et_input.setText(result + "");
					}

				} else if (s1.equals("") && !s2.equals("")) { // s1 Ϊ�գ�s2�� Ϊ��
					MyLogUtil.d(TAG, "s1 Ϊ�գ�s2 ��Ϊ�� ");
					if (op.equals("-")) {
						double d2 = Double.parseDouble(s2);

						// �ж��Ƿ���С������
						if (!s2.contains(".")) {
							// ��ΪС��
							r = -(int) d2;
							et_input.setText(r + "");
						} else {
							// ��С��
							et_input.setText(-d2 + "");

						}

					} else if (op.equals("+")) {
						double d2 = Double.parseDouble(s2);
						// �ж��Ƿ���С������
						if (!s2.contains(".")) {
							// ��ΪС��
							r = (int) d2;
							et_input.setText(r + "");
						} else {
							// ��С��
							et_input.setText(d2 + "");
						}
					} else if (op.equals("/") || op.equals("*")) {
						et_input.setText(exp);
					}

				} else if (s1.equals("") && s2.equals("")) { // s1 Ϊ�գ�s2Ϊ��
					MyLogUtil.d(TAG, "s1 Ϊ�գ�s2 Ϊ�� ");
					et_input.setText(exp);
				}

			} else {
				// ��������������ֻ�е�һ��������ʱ
				MyLogUtil.d(TAG, "��������������ֻ�е�һ��������ʱ ");

				double result;

				s1 = exp;
				double d1 = Double.parseDouble(s1);
				// �ж��Ƿ���С������
				if (!s1.contains(".")) {
					// ����С������
					MyLogUtil.d(TAG, "��������������ֻ�е�һ��������ʱ ,�Ҳ�ΪС��");
					r = (int) d1;
					et_input.setText(r + "");
				} else {
					// ��С������
					MyLogUtil.d(TAG, "��������������ֻ�е�һ��������ʱ ,��ΪС��");
					result = d1;
					et_input.setText(result + "");
				}

			}

			/***********************************************************************************/

			et_warning.setText(s1 + op + s2 + "=");
		} else {
			// ����������������
			et_warning.setText("�Բ�����ֻ֧��������������.");
			clear_flag = true;

		}

		// ��Ȥζ��ʶ��Ϊtrueʱ���Ž���Ȥζģʽ
		if (interst_flag) {
			if (r == 520) {
				et_warning.setText("�Ұ���!   ");
			} else if (r == 1314) {
				et_warning.setText("һ��һ��...   ");
			} else if (r == 1314521) {
				et_warning.setText("һ��һ��,�Ұ��㣡^_^   ");
			} else if (r == 250) {
				et_warning.setText("����250�� @^��^@   ");
			} else {
				et_warning.setText("ɵ���˰ɡ�T_T, �㲻�����˰�, ������  ");
			}
		}

	}
}
