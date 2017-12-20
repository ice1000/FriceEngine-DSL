import org.frice.dsl.游戏

fun main(args: Array<String>) {
	val 障碍物名 = "南墙"
	游戏 {
		边界(100, 100, 800, 750)
		显示帧率 = true

		当退出时 {
			关闭窗口()
		}

		当更新时 {
			if (800.毫秒后()) {
				长方形 {
					x = elapsed / 10.0
					y = elapsed / 10.0
					color = PINK
				}
			}
		}

		每隔(1000) {
			椭圆 {
				x = elapsed / 10.0
				y = elapsed / 10.0
				color = ORANGE
			}
			log("1 second has past.")
		}

		长方形 {
			name(障碍物名)
			x = 100.0
			y = 100.0
			width = 100.0
		}
		椭圆 {
			x = 0.0
			y = 85.0
			加速 {
				x = 10.0
//				y = 10.0
			}
			当碰撞(障碍物名) {
				停止()
				x -= 5
				加速(-2, 10)
			}
		}
		图片 {
			url("https://avatars3.githubusercontent.com/u/16398479")
			x = 200.0
			y = 300.0
			速度 {
				x = -5.5
//				y = -5.5
			}
		}
	}
}