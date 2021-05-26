extends Area2D

# This class is being used for the detection of the player and to follow the
# player. If the player body is present then this is set to true. This is further
# utilized in 'Bat.gd'.

var player = null

func can_see_player():
	return player != null

# Detection the intrution of a body
func _on_PlayerDetectionZone_body_entered(body):
	player = body

func _on_PlayerDetectionZone_body_exited(_body):
	player = null
