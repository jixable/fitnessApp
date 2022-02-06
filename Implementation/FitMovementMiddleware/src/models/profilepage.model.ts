import {Entity, model, property} from '@loopback/repository';

@model()
export class Profilepage extends Entity {
  @property({
    type: 'string',
    id: true,
    generated: false,
    required: true,
  })
  USERNAME: string;

  @property({
    type: 'string',
  })
  PICTURE_HASH?: string;

  @property({
    type: 'string',
  })
  BIO?: string;

  @property({
    type: 'number',
  })
  MAIN_GYM?: number;


  constructor(data?: Partial<Profilepage>) {
    super(data);
  }
}

export interface ProfilepageRelations {
  // describe navigational properties here
}

export type ProfilepageWithRelations = Profilepage & ProfilepageRelations;
