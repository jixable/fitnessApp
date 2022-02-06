import {Entity, model, property} from '@loopback/repository';

@model()
export class Authentication extends Entity {
  @property({
    type: 'string',
    id: true,
    generated: false,
    required: true,
  })
  USERNAME: string;

  @property({
    type: 'string',
    required: true,
  })
  PASS_HASH: string;

  @property({
    type: 'number',
  })
  USER_ROLE?: number;


  constructor(data?: Partial<Authentication>) {
    super(data);
  }
}

export interface AuthenticationRelations {
  // describe navigational properties here
}

export type AuthenticationWithRelations = Authentication & AuthenticationRelations;
