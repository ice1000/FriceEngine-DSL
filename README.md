# Frice DSL

This is a DSL system for FriceEngine.<br/>
And it's written in **Kotlin**.

# What does the "DSL" look like

```kotlin
/* C-style comments are allowed */
// a necessary main function
fun main(args: Array<String>) {
	// create a game window(this means you can create more than one window simply by using more than one "game" block.
	game {
//		size(10, 10)
		bounds(500, 500, 800, 750)
		showFPS = false

		// called when 'close button' is clicked
		whenExit {
			closeWindow()
		}

		// called when scene has refreshed
		whenUpdate {
			// if 800ms has past
			if (800.elapsed()) {
				rectangle {
					// elapsed = millis second from game create
					x = elapsed / 10.0
					y = elapsed / 10.0
					// colors are represented CAPITALLY.
					color = PINK
				}
			}
		}

		// will be invoked every 1000ms
		every(1000) {
			oval {
				x = elapsed / 10.0
				y = elapsed / 10.0
				color = ORANGE
			}
			// write logs into a file "frice.log"
			log("1 second has past.")
		}

		// add a rectangle to the game scene
		rectangle {
			// name is an identifier of the game object.
			name("rectangle")
			// location
			x = 100.0
			y = 100.0
			// size setting is allowed
			width = 100.0
		}
		oval {
			x = 0.0
			y = 85.0
			// let the object move with acceleration.
			accelerate {
				x = 10.0
//				y = 10.0
			}
			// when colliding the object naming of the given string("rectangle" here), the code in the block will be called.
			whenColliding("rectangle") {
				// stop moving
				stop()
				// change position
				x -= 5
				// move with acceleration again
				accelerate {
					x = -2.0
					y = 10.0
				}
			}
		}
		// add an object displaying image.
		image {
			// from file
			file("C:/frice.png")
			// using url is allowed
//			url("https://avatars3.githubusercontent.com/u/16398479")
			x = 200.0
			y = 300.0
			// move simply
			velocity {
				x = -5.5
//				y = -5.5
			}
		}
	}
}
```

### It is clearer if I delete the comments.

```kotlin
fun main(args: Array<String>) {
	game {
		bounds(500, 500, 800, 750)
		showFPS = false

		whenExit {
			closeWindow()
		}

		whenUpdate {
			if (800.elapsed()) {
				rectangle {
					x = elapsed / 10.0
					y = elapsed / 10.0
					color = PINK
				}
			}
		}

		every(1000) {
			oval {
				x = elapsed / 10.0
				y = elapsed / 10.0
				color = ORANGE
			}
			log("1 second has past.")
		}

		rectangle {
			name("rectangle")
			x = 100.0
			y = 100.0
			width = 100.0
		}
		oval {
			x = 0.0
			y = 85.0
			accelerate {
				x = 10.0
			}
			whenColliding("rectangle") {
				stop()
				x -= 5
				accelerate {
					x = -2.0
					y = 10.0
				}
			}
		}
		image {
			file("C:/frice.png")
			x = 200.0
			y = 300.0
			velocity {
				x = -5.5
			}
		}
	}
}
```

See? The syntax looks like the one Gradle scripts, but more powerful, clear and easy.

And they are all **valid Kotlin codes**.

# How to use

Simply using Kotlin compiler **kotlinc** to compile your code, with classpath directing this project and the jar of FriceEngine.

