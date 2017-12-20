import org.frice.dsl.game

fun main(args: Array<String>) {
	val 障碍物名 = "南墙"
	game {
		bounds(500, 500, 800, 750)
		showFPS = false

		whenExit {
			closeWindow()
		}

		whenUpdate {
			if (800.elapsed()) {
				长方形 {
					x = elapsed / 10.0
					y = elapsed / 10.0
					color = PINK
				}
			}
		}

		every(1000) {
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
			accelerate {
				x = 10.0
//				y = 10.0
			}
			当碰撞(障碍物名) {
				stop()
				x -= 5
				accelerate(-2, 10)
			}
		}
		image {
			url("https://avatars3.githubusercontent.com/u/16398479")
			x = 200.0
			y = 300.0
			velocity {
				x = -5.5
//				y = -5.5
			}
		}
	}
}