extends AudioStreamPlayer

# The following class seeks to change the damage the 'Player' does by
# changing it every second so to match the 120 BPM (Beats Per Minute)

onready var damage = HitBox
onready var count = 1
onready var on = $CanvasLayer/Control/AnimationPlayer

# For the following code, I was confused in changing the damage every other beat
# so I looked for help and found answeres in here
# https://godotengine.org/qa/15160/how-to-make-part-of-script-always-repeat-in-
# loop-after-seconds
# The code is actually unnecceary and could be done with another Node added to
# the tree. But, I needed to follow the logic so I left it as hard code, instead
# of using another node. The logic placed at the ended though is mine and not
# borrowed.

# The _ready() function is called when the node, and all its children, enters 
# the active scene. - Not a constructor.

func _ready():
	# Create a timer node.
	var timer = Timer.new()
	

	# Set timer interval.
	timer.set_wait_time(1.0)

	# Set it as repeat.
	timer.set_one_shot(false)

	# Connect its timeout signal to the function you want to repeat.
	timer.connect("timeout", self, "increase_damage")

	# Add to the tree as child of the current node.
	add_child(timer)

	timer.start()

# This changes both 'damage.damage' and the shader of the 'BeatBar'.
func increase_damage():
	if count != 1:
		damage.set_damage(2)
		on.play("Start")
		count = count - 1
	else:
		damage.set_damage(1)
		on.play("Stop")
		count = count + 1
