"""Functions used in preparing Guido's gorgeous lasagna.

Learn about Guido, the creator of the Python language: https://en.wikipedia.org/wiki/Guido_van_Rossum
"""


EXPECTED_BAKE_TIME = 40
PREPARATION_TIME = 2


def bake_time_remaining(time_elapsed):
    """Calculate the bake time remaining.

    :param elapsed_bake_time: int - baking time already elapsed.
    :return: int - remaining bake time (in minutes) derived from 'EXPECTED_BAKE_TIME'.

    Function that takes the actual minutes the lasagna has been in the oven as
    an argument and returns how many minutes the lasagna still needs to bake
    based on the `EXPECTED_BAKE_TIME`.
    """
    return EXPECTED_BAKE_TIME - time_elapsed




def preparation_time_in_minutes(nb_layers):
    """
    Return elapsed preparation time.

    :param nb_layers: int - number of layers
    :return: int - minutes spent preparing the lasagna
    This function takes the number of layers and calculates the time spent preparing the lasagna.
    """
    return PREPARATION_TIME * nb_layers

def elapsed_time_in_minutes(nb_layers, elapsed_bake_time):
    """
    Return elapsed cooking time.

    :param nb_layers: int - number of layers
    :param elapsed_bake_time: int - baking time already elapsed.
    :return: int - total elapsed minutes spent cooking the lasagna
    This function takes two numbers representing the number of layers & the time already spent
    baking and calculates the total elapsed minutes spent cooking the lasagna.
    """
    return elapsed_bake_time + preparation_time_in_minutes(nb_layers)
    